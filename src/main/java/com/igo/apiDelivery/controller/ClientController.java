package com.igo.apiDelivery.controller;

import com.igo.apiDelivery.model.Client;
import com.igo.apiDelivery.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/food/clients")
public class ClientController {

    private final ClientService clientService;

    @PostMapping()
    public Client insertClient(@RequestBody Client client){
        return clientService.insertClient(client);
    }
    @GetMapping("/{id}")
    public Client findByIdClient(@PathVariable("id") Long id){
        return clientService.findByIdClient(id);
    }
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable("id") Long id){
        clientService.deleteClient(id);
    }
}
