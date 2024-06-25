package com.igo.apiDelivery.service;

import com.igo.apiDelivery.dto.ItemDTO;
import com.igo.apiDelivery.model.Bag;
import com.igo.apiDelivery.model.Item;

public interface BagService {
    Item inserItem(ItemDTO itemDTO);
    Bag findBag(Long id);
    Bag closeBag(Long id, int formaPagamento);
}
