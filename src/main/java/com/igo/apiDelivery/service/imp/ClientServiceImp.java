package com.igo.apiDelivery.service.imp;

import com.igo.apiDelivery.exception.RecordNotFoundException;
import com.igo.apiDelivery.model.Client;
import com.igo.apiDelivery.repository.ClientRepository;
import com.igo.apiDelivery.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientServiceImp implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public Client insertClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client findByIdClient(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    @Override
    public Client updateClient(Long id, Client client) {
        return clientRepository.findById(id)
                .map(client1 -> {
                    client1.setName(client.getName());
                    client1.setEmail(client.getEmail());
                    client1.setAddress(client.getAddress());
                    client1.setBag(client.getBag());

                   return clientRepository.save(client1);

                }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.delete(clientRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
