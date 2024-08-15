package com.igo.apiDelivery.dto.mapper;

import com.igo.apiDelivery.dto.ItemDTO;
import com.igo.apiDelivery.dto.ItemInformationDTO;
import com.igo.apiDelivery.model.Item;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ItemInformationMapper {

    private final ProductMapper productMapper;

    public ItemInformationDTO toDTO(Item item){
        if(item == null){
            return null;
        }

        return new ItemInformationDTO(
                productMapper.toDTO(item.getProduct()),
                item.getAmount()
        );
    }
}
