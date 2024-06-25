package com.igo.apiDelivery.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)

    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    private String imgURL;
    private boolean avaliable = true;

    @ManyToOne
    private Restaurant restaurant;

    @OneToMany
    private Category category;

}
