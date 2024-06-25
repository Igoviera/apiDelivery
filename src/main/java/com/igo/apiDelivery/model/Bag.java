package com.igo.apiDelivery.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_bag")
public class Bag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal total;
    private boolean fechada;
    private LocalDate dataPedido;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany
    private List<Item> items;

}
