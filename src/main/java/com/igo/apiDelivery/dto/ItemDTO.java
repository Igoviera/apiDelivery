package com.igo.apiDelivery.dto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Embeddable
public record ItemDTO(
        Long productId,
        Integer amount,
        ProductDTO product,
        Long bagId
) {}
