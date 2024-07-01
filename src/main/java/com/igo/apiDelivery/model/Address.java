package com.igo.apiDelivery.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {
    @NotEmpty(message = "Campo cep é obrigatório")
    @Column(nullable = false, unique = true)
    private String cep;
    @NotEmpty(message = "Campo complemento é obrigatório")
    private String complemento;
}
