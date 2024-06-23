package com.igo.apiDelivery.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Adress {
    @Column(nullable = false, unique = true)
    private String cep;
    private String complemento;
}
