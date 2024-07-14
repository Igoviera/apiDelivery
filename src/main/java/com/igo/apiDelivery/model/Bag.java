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
import java.util.ArrayList;
import java.util.List;
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_bag")
public class Bag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "total", precision = 20, scale = 2)
    private BigDecimal total;
    private boolean closed;
    @Enumerated(EnumType.ORDINAL)
    private PaymentMethod paymentMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Client client;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();

    private LocalDate createdAt;

}
