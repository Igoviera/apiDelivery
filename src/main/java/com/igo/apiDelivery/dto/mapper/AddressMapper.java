package com.igo.apiDelivery.dto.mapper;

import com.igo.apiDelivery.dto.AddressDTO;
import com.igo.apiDelivery.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressDTO toDTO(Address address){
        if (address == null){
            return null;
        }

        return new AddressDTO(
            address.getCep(),
            address.getLogradouro()
        );
    }

    public Address toEntity(AddressDTO addressDTO){
        if (addressDTO == null){
            return null;
        }

        Address address = new Address();
        address.setCep(addressDTO.cep());
        address.setLogradouro(addressDTO.logradouro());

        return address;
    }
}
