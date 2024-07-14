package com.igo.apiDelivery.service;

import com.igo.apiDelivery.dto.BagDTO;
import com.igo.apiDelivery.dto.ItemDTO;
import com.igo.apiDelivery.model.Bag;
import com.igo.apiDelivery.model.Item;

public interface BagService {
    Item inserItem(ItemDTO itemDTO);
    BagDTO getBagDatails(Long bagId);
    Bag findBag(Long id);
    BagDTO closedBag(Long id, int paymentMethod);
}
