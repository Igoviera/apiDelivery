package com.igo.apiDelivery.dto;

import jakarta.persistence.Embeddable;


@Embeddable
public record ItemDTO(
        Long productId,
        Integer amount,
        ProductDTO product,
        Long bagId
) {}
