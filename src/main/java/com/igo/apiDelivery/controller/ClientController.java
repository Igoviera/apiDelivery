package com.igo.apiDelivery.controller;

import com.igo.apiDelivery.dto.ClientDTO;
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
    public ClientDTO insertClient(@RequestBody @Valid ClientDTO clientDTO){
        return clientService.insertClient(clientDTO);
    }
    @GetMapping
    public List<ClientDTO> findAllClients(){
        return clientService.findAllClients();
    }
    @GetMapping("/{id}")
    public ClientDTO findByIdClient(@PathVariable("id") Long id){
        return clientService.findByIdClient(id);
    }

    @PutMapping("/{id}")
    public  ClientDTO updateClient(@PathVariable("id") Long id, @RequestBody ClientDTO clientDTO){
        return clientService.updateClient(id, clientDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable("id") Long id){
        clientService.deleteClient(id);
    }
}
