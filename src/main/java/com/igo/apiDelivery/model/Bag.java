package com.igo.apiDelivery.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.igo.apiDelivery.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_bag")
public class Bag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal total;
    private boolean close;
    //private LocalDate dataPedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Client client;

    @Enumerated(EnumType.ORDINAL)
    private PaymentMethod paymentMethod;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items;

}
