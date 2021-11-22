package com.switchfully.parkshark.mapper;

import com.switchfully.parkshark.dto.address.AddressDTO;
import com.switchfully.parkshark.dto.address.CreateAddressDTO;
import com.switchfully.parkshark.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public Address toEntity(CreateAddressDTO dto) {
        return new Address.Builder()
                .withStreet(dto.getStreet())
                .withCity(dto.getCity())
                .withHouseNumber(dto.getHouseNumber())
                .withZipcode(dto.getZipcode())
                .build();
    }

    public AddressDTO toDto(Address address) {
        return new AddressDTO.Builder()
                .withAddressId(address.getAddressId())
                .withStreet(address.getStreet())
                .withHouseNumber(address.getHouseNumber())
                .withCity(address.getCity())
                .withZipcode(address.getZipcode())
                .build();
    }

}
