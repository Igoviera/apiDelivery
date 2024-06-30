package com.igo.apiDelivery.controller;

import com.igo.apiDelivery.model.Client;
import com.igo.apiDelivery.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/food/clients")
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/{id}")
    public Client findByIdClient(@PathVariable("id") Long id){
        return clientService.findByIdClient(id);
    }
}
