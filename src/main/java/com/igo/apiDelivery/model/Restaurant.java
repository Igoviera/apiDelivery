package com.igo.apiDelivery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Embedded
    private Address address;

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonIgnore
    @OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER)
    private Set<Product> products = new HashSet<>();

}
