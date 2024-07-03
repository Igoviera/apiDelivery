package com.igo.apiDelivery.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Campo nome é obrigatório")
    @Column(nullable = false)
    private String name;

    @NotEmpty(message = "Campo e-mail é obrigatório")
    @Email(message = "Informe um e-mail válido")
    @Column(nullable = false, unique = true)
    private String email;

    @Embedded
    @Valid
    private Address address;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private Bag bag;

}
