package com.igo.apiDelivery.service.imp;

import com.igo.apiDelivery.dto.BagDTO;
import com.igo.apiDelivery.dto.ItemDTO;
import com.igo.apiDelivery.dto.ItemInformationDTO;
import com.igo.apiDelivery.dto.mapper.BagMapper;
import com.igo.apiDelivery.dto.mapper.ItemInformationMapper;
import com.igo.apiDelivery.dto.mapper.ItemMapper;
import com.igo.apiDelivery.enums.OrderStatus;
import com.igo.apiDelivery.enums.PaymentMethod;
import com.igo.apiDelivery.exception.BagClosedException;
import com.igo.apiDelivery.exception.BagEmptyException;
import com.igo.apiDelivery.exception.RecordNotFoundException;
import com.igo.apiDelivery.model.Bag;
import com.igo.apiDelivery.model.Item;
import com.igo.apiDelivery.model.Product;
import com.igo.apiDelivery.model.Restaurant;
import com.igo.apiDelivery.repository.BagRepository;
import com.igo.apiDelivery.repository.ItemRepository;
import com.igo.apiDelivery.repository.ProductRepository;
import com.igo.apiDelivery.service.BagService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BagServiceImp implements BagService {

    private final BagRepository bagRepository;
    private final ProductRepository productRepository;
    private final ItemRepository itemRepository;

    private final ItemMapper itemMapper;
    private final BagMapper bagMapper;
    private final ItemInformationMapper itemInformationMapper;

    @Override
    @Transactional
    public ItemDTO inserItem(ItemDTO itemDTO) {
        Bag bag = findBag(itemDTO.bagId());

        if (bag.isClosed()){
            throw new BagClosedException();
        }

        Item item = new Item();
        item.setAmount(itemDTO.amount());
        item.setBag(bag);
        item.setProduct(productRepository.findById(itemDTO.productId())
                .orElseThrow(() -> new RecordNotFoundException(itemDTO.productId())));

        List<Item> items = bag.getItems();
        if (items.isEmpty()){
            items.add(item);
        } else {
            Restaurant currentRestaurant = items.get(0).getProduct().getRestaurant();
            Restaurant newItemRestaurant = item.getProduct().getRestaurant();

            if (currentRestaurant.equals(newItemRestaurant)){
                items.add(item);
            } else {
                throw new RuntimeException("Não é possível adicionar produtos de restaurantes diferentes.");
            }
        }

        BigDecimal total = items.stream()
                .map(item1 -> item1.getProduct().getPrice()
                        .multiply(BigDecimal.valueOf(item1.getAmount())))
                .reduce(BigDecimal.ZERO, (subtotal, element) -> subtotal.add(element));

        bag.setTotal(total);
        bagRepository.save(bag);

        return itemMapper.toDTO(item);
    }

//    @Override
//    public ItemInformationDTO findByIdItem(Long id) {
//        Item item = itemRepository.findById(id)
//                .orElseThrow(() -> new RecordNotFoundException(id));
//
//        return itemInformationMapper.toDTO(item);
//    }

    @Override
    @Transactional
    public BagDTO deleteItemBag(Long bagId, Long itemId) {
      Bag bag = findBag(bagId);

      Item itemToRemove = bag.getItems().stream()
              .filter(item -> item.getId().equals(itemId))
              .findFirst()
              .orElseThrow(() -> new  RecordNotFoundException(itemId));

      bag.getItems().remove(itemToRemove);
      bag.setTotal(bag.getTotal().subtract(itemToRemove.getProduct().getPrice()));

      itemRepository.delete(itemToRemove);

      return bagMapper.toDTO(bagRepository.save(bag));

    }

    @Override
    public Bag findBag(Long id) {
      return bagRepository.findById(id)
              .orElseThrow(() -> new RecordNotFoundException(id));
    }

    @Override
    public BagDTO closedBag(Long id, int paymentMethod) {
        Bag bag = findBag(id);

        if (bag.getItems().isEmpty()){
            throw new BagEmptyException();
        }

        PaymentMethod paymentMethod1 = paymentMethod == 0 ? PaymentMethod.DINHEIRO : PaymentMethod.MAQUINETA;

        bag.setPaymentMethod(paymentMethod1);
        bag.setCreatedAt(LocalDateTime.now());
        bag.setStatus(OrderStatus.IN_PREPARATION);
        bag.setClosed(true);

        return bagMapper.toDTO(bagRepository.save(bag));
    }
}
