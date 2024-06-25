package com.igo.apiDelivery.service.imp;

import com.igo.apiDelivery.dto.ItemDTO;
import com.igo.apiDelivery.model.Bag;
import com.igo.apiDelivery.model.Item;
import com.igo.apiDelivery.repository.BagRepository;
import com.igo.apiDelivery.service.BagService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BagServiceImp implements BagService {

    private BagRepository bagRepository;

    @Override
    public Item inserItem(ItemDTO itemDTO) {
      return null;
    }

    @Override
    public Bag findBag(Long id) {
       return bagRepository.findById(id)
               .orElseThrow(() -> {
                   throw new RuntimeException("Sacola não encontrada.");
               });
    }

    @Override
    public Bag closeBag(Long id, int formaPagamento) {
        return null;
    }
}
