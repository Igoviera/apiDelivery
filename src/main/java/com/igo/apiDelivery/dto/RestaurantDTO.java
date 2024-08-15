package com.igo.apiDelivery.dto;

import com.igo.apiDelivery.model.Address;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

public record RestaurantDTO(
        Long id,
        @NotEmpty(message = "O campo nome é obrigatório")
        String name,
        String imageUrl,
        @NotNull(message = "O campo taxa de frete é obrigatório")
        @DecimalMin(value = "0.0", inclusive = false, message = "A taxa de frete deve ser maior que 0")
        BigDecimal freightRate,
        @NotNull(message = "O campo status é obrigatório")
        Boolean status,
        @NotBlank(message = "O tempo estimado de entrega é obrigatório")
        String estimatedDeliveryTime,
        @NotNull(message = "O horário de abertura é obrigatório")
        LocalTime openingTime,
        @NotNull(message = "O horário de fechamento é obrigatório")
        LocalTime closingTime,
        @Valid
        AddressDTO address,
        Set<ProductDTO> products
) {
        public RestaurantDTO {
                products = (products == null) ? Set.of() : products;
        }
}
