package com.igo.apiDelivery.dto;

import com.igo.apiDelivery.model.Address;
import com.igo.apiDelivery.model.Bag;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record ClientDTO(
        Long id,

        @NotEmpty(message = "Campo nome é obrigatório")
        String name,

        @NotEmpty(message = "Campo e-mail é obrigatório")
        @Email(message = "Informe um e-mail válido")
        String email,

        @Valid
        AddressDTO address,
        Long bag
){}
