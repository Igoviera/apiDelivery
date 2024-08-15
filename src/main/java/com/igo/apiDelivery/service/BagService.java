package com.igo.apiDelivery.service;

import com.igo.apiDelivery.dto.BagDTO;
import com.igo.apiDelivery.dto.ItemDTO;
import com.igo.apiDelivery.dto.ItemInformationDTO;
import com.igo.apiDelivery.model.Bag;
import com.igo.apiDelivery.model.Item;

public interface BagService {
    ItemDTO inserItem(ItemDTO itemDTO);
    BagDTO deleteItemBag(Long bagId, Long itemId);
    Bag findBag(Long id);
    BagDTO closedBag(Long id, int paymentMethod);
}
