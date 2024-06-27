package com.igo.apiDelivery.service;

import com.igo.apiDelivery.model.Client;

public interface ClientService {
    Client insertClient(Client client);
    Client findByIdClient(Long id);
    Client updateClient(Long id, Client client);
    void deleteClient(Long id);
}
