package com.igo.apiDelivery.service.imp;

import com.igo.apiDelivery.dto.BagDTO;
import com.igo.apiDelivery.dto.ItemDTO;
import com.igo.apiDelivery.dto.mapper.BagMapper;
import com.igo.apiDelivery.enums.PaymentMethod;
import com.igo.apiDelivery.exception.BagEmptyException;
import com.igo.apiDelivery.exception.RecordNotFoundException;
import com.igo.apiDelivery.model.Bag;
import com.igo.apiDelivery.model.Item;
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
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BagServiceImp implements BagService {

    private final BagRepository bagRepository;
    private final ProductRepository productRepository;
    private final ItemRepository itemRepository;
    private final BagMapper bagMapper;

    @Override
    @Transactional
    public Item inserItem(ItemDTO itemDTO) {
        Bag bag = findBag(itemDTO.bagId());

        if (bag.isClosed()){
            throw new RuntimeException("Sacola está fechada.");
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

        return item;
    }

    @Override
    public BagDTO getBagDatails(Long bagId) {
        Bag bag = bagRepository.findById(bagId)
                .orElseThrow(() -> new RecordNotFoundException(bagId));

        return bagMapper.toDTO(bag);
    }

    @Override
    public Bag findBag(Long id) {
      return bagRepository.findById(id)
              .orElseThrow(() -> new RecordNotFoundException(id));
    }

    @Override
    public Bag closedBag(Long id, int paymentMethod) {
        Bag bag = findBag(id);

        if (bag.getItems().isEmpty()){
            throw new BagEmptyException();
        }

        PaymentMethod paymentMethod1 = paymentMethod == 0 ? PaymentMethod.DINHEIRO : PaymentMethod.MAQUINETA;

        bag.setPaymentMethod(paymentMethod1);
        bag.setCreatedAt(LocalDate.now());
        bag.setClosed(true);

        return bagRepository.save(bag);
    }
}
