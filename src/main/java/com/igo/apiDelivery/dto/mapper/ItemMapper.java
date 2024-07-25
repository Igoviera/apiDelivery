package com.igo.apiDelivery.dto.mapper;

import com.igo.apiDelivery.dto.ItemDTO;
import com.igo.apiDelivery.model.Item;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ItemMapper {

    private final ProductMapper productMapper;

    public ItemDTO toDTO(Item item){
        if (item == null){
            return null;
        }

        return new ItemDTO(
                item.getId(),
                item.getAmount(),
                productMapper.toDTO(item.getProduct()),
                item.getBag() != null ? item.getBag().getId() : null
        );
    }
}
