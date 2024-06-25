package com.igo.apiDelivery.dto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ItemDTO {
    private Long produtoId;
    private Integer quantidade;
    private Long sacolaId;
}
