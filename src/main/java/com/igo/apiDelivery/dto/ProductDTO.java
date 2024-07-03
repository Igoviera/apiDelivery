package com.igo.apiDelivery.dto;

import com.igo.apiDelivery.model.Restaurant;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

public record ProductDTO(
        @NotEmpty(message = "Campo nome é obrigatório.")
        @Length(max = 100,message = "Campo nome não pode ultrapassar 100 caracteres.")
        String name,
        @NotEmpty(message = "Campo descrição é obrigatório.")
        @Length(max = 100,message = "Campo descrição não pode ultrapassar 100 caracteres.")
        String description,
        @NotNull(message = "Campo preço é obrigatório.")
        BigDecimal price,
        String imgURL,
        boolean avaliable,
        @NotEmpty(message = "Campo restaurante é obrigatório.")
        Restaurant restaurant
) {
}
