package com.igo.apiDelivery.dto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class bagDTO {
    private Long client;
    private BigDecimal Total;
    private List<ItemDTO>itemDTOS;
}
