package com.igo.apiDelivery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Campo nome é obrigatório")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Opening hours are mandatory")
    private String openingHours;

    private String imageUrl;

    @NotNull(message = "O campo status é obrigatório")
    private Boolean status;

    @Embedded
    @Valid
    private Address address;

    @NotNull(message = "O campo taxa de frete é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "A taxa de frete deve ser maior que 0")
    private BigDecimal freightRate;

    @NotBlank(message = "O tempo estimado de entrega é obrigatório")
    private String estimatedDeliveryTime;

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //@JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant", fetch = FetchType.EAGER)
    private Set<Product> products = new HashSet<>();

}
