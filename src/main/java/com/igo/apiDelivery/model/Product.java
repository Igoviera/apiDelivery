package com.igo.apiDelivery.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_product")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Campo nome é obrigatório")
    @Column(nullable = false)
    private String name;

    @NotEmpty(message = "Campo descrição é obrigatório")
    @Column(nullable = false)
    private String description;

    @NotNull(message = "Campo preço é obrigatório")
    private BigDecimal price;

    private String imgURL;
    private boolean avaliable = true;

    @NotEmpty(message = "Campo restaurante é obrigatório")
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

//    @OneToMany()
//    @JoinColumn(name = "category_id")
//    private Category category;

}
