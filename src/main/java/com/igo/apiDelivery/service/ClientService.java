package com.igo.apiDelivery.service;

import com.igo.apiDelivery.dto.ClientDTO;
import com.igo.apiDelivery.model.Client;

import java.util.List;

public interface ClientService {
    ClientDTO insertClient(ClientDTO clientDTO);
    List<ClientDTO> findAllClients();
    ClientDTO findByIdClient(Long id);
    ClientDTO updateClient(Long id, ClientDTO clientDTO);
    void deleteClient(Long id);
}
