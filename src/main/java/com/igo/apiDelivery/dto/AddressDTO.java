package com.igo.apiDelivery.dto;

import jakarta.validation.constraints.NotEmpty;

public record AddressDTO(
        @NotEmpty(message = "O campo CEP é obrigatório")
        String cep,

        @NotEmpty(message = "O campo logradouro é obrigatório")
        String logradouro
) {}
