package com.igo.apiDelivery.dto.mapper;

import com.igo.apiDelivery.dto.BagDTO;
import com.igo.apiDelivery.model.Bag;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class BagMapper {

    private final ItemMapper itemMapper;

    public BagDTO toDTO(Bag bag){
        if (bag == null){
            return null;
        }

        return new BagDTO(
                bag.getId(),
                bag.getTotal(),
                bag.isClosed(),
                bag.getPaymentMethod(),
                bag.getCreatedAt(),
                bag.getClient() != null ? bag.getClient().getName() : null,
                bag.getStatus(),
                bag.getItems().stream()
                        .map(itemMapper::toDTO)
                        .collect(Collectors.toList())
        );
    }
}
