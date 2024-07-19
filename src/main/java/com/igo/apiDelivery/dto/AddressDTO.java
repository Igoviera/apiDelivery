package com.igo.apiDelivery.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;

public record AddressDTO(
        @NotEmpty(message = "O campo CEP é obrigatório")
        String cep,

        @NotEmpty(message = "O campo logradouro é obrigatório")
        String logradouro,

        @NotEmpty(message = "Campo número é obrigatório")
        String locationNumber
) {}
