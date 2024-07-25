package com.igo.apiDelivery.dto.mapper;

import com.igo.apiDelivery.dto.AddressDTO;
import com.igo.apiDelivery.dto.ClientDTO;
import com.igo.apiDelivery.model.Address;
import com.igo.apiDelivery.model.Client;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClientMapper {

    private AddressMapper addressMapper;

    public ClientDTO toDto(Client client){
        if (client == null){
            return null;
        }

        return new ClientDTO(
                client.getId(),
                client.getName(),
                client.getEmail(),
                addressMapper.toDTO(client.getAddress()),
                client.getBag() != null ? client.getBag().getId() : null
        );
    }

    public Client toEntity(ClientDTO clientDTO){
        if (clientDTO == null){
            return null;
        }

        Client client = new Client();
        client.setName(clientDTO.name());
        client.setEmail(clientDTO.email());
        client.setAddress(addressMapper.toEntity(clientDTO.address()));

        return client;
    }
}
