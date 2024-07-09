package com.igo.apiDelivery.dto;

import jakarta.validation.constraints.NotEmpty;

public record AddressDTO(
        String cep,
        String complemento
) {}
