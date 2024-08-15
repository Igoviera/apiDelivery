package com.igo.apiDelivery.dto;
public record ItemDTO(
        Long productId,
        Integer amount,
        ProductDTO product,
        Long bagId
) {}
