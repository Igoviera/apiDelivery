package com.igo.apiDelivery.dto;

import com.igo.apiDelivery.model.Address;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public record RestaurantDTO(

        Long id,

        @NotEmpty(message = "O campo nome é obrigatório")
        String name,

        @NotBlank(message = "O campo horário de funcionamento é obrigatório")
        String openingHours,

        String imageUrl,

        @NotNull(message = "O campo taxa de frete é obrigatório")
        @DecimalMin(value = "0.0", inclusive = false, message = "A taxa de frete deve ser maior que 0")
        BigDecimal freightRate,

        @NotNull(message = "O campo status é obrigatório")
        Boolean status,

        @NotBlank(message = "O tempo estimado de entrega é obrigatório")
        String estimatedDeliveryTime,

        @Valid
        AddressDTO address,

        Set<ProductDTO> products
) {
        public RestaurantDTO {
                products = (products == null) ? Set.of() : products;
        }
}
