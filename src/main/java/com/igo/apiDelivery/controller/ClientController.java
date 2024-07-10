package com.igo.apiDelivery.controller;

import com.igo.apiDelivery.model.Client;
import com.igo.apiDelivery.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/food/clients")
public class ClientController {

    private final ClientService clientService;

    @PostMapping()
    public Client insertClient(@RequestBody @Valid Client client){
        return clientService.insertClient(client);
    }

    @GetMapping
    public List<Client> findAllClients(){
        return clientService.findAllClients();
    }
    @GetMapping("/{id}")
    public Client findByIdClient(@PathVariable("id") Long id){
        return clientService.findByIdClient(id);
    }

    @PutMapping("/{id}")
    public  Client updateClient(@PathVariable("id") Long id, @RequestBody Client client){
        return clientService.updateClient(id, client);
    }
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable("id") Long id){
        clientService.deleteClient(id);
    }
}
