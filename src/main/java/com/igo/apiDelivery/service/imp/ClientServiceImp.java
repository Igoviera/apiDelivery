package com.igo.apiDelivery.service.imp;

import com.igo.apiDelivery.dto.ClientDTO;
import com.igo.apiDelivery.dto.mapper.AddressMapper;
import com.igo.apiDelivery.dto.mapper.ClientMapper;
import com.igo.apiDelivery.exception.RecordNotFoundException;
import com.igo.apiDelivery.model.Address;
import com.igo.apiDelivery.model.Client;
import com.igo.apiDelivery.repository.ClientRepository;
import com.igo.apiDelivery.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ClientServiceImp implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final AddressMapper addressMapper;

    @Override
    public ClientDTO insertClient(ClientDTO clientDTO) {
        return clientMapper.toDto(clientRepository.save(clientMapper.toEntity(clientDTO)));
    }

    @Override
    public List<ClientDTO> findAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(client -> clientMapper.toDto(client))
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO findByIdClient(Long id) {
        return clientMapper.toDto(clientRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }

    @Override
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        return clientRepository.findById(id)
                .map(existingClient -> {
                    existingClient.setName(clientDTO.name());
                    existingClient.setEmail(clientDTO.email());
                    //existingClient.setBag(clientDTO.bag());
                    existingClient.setAddress(addressMapper.toEntity(clientDTO.address()));


                    Client updatedClient = clientRepository.save(existingClient);

                    return clientMapper.toDto(updatedClient);

                })
                .orElseThrow(() -> new RecordNotFoundException(id));

    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.delete(clientRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
