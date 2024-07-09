package com.igo.apiDelivery.dto;

import com.igo.apiDelivery.model.Address;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;
import java.util.Set;

public record RestaurantDTO(
        Long id,
        String name,
        AddressDTO address,
        Set<ProductDTO> products
) {
        public RestaurantDTO {
                products = (products == null) ? Set.of() : products;
        }
}
