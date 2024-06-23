package com.igo.apiDelivery.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Embedded
    private Adress adress;

    private List<Product> products;

}
