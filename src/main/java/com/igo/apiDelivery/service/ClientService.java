package com.igo.apiDelivery.service;

import com.igo.apiDelivery.model.Client;

import java.util.List;

public interface ClientService {
    Client insertClient(Client client);
    List<Client> findAllClients();
    Client findByIdClient(Long id);
    Client updateClient(Long id, Client client);
    void deleteClient(Long id);
}
