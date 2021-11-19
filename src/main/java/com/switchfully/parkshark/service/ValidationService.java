package com.switchfully.parkshark.service;

import com.switchfully.parkshark.dto.CreateAddressDTO;
import com.switchfully.parkshark.dto.CreateLicensePlateDTO;
import com.switchfully.parkshark.dto.CreateMemberDTO;
import com.switchfully.parkshark.exceptions.BadCreateAddressException;
import com.switchfully.parkshark.exceptions.BadCreateLicensePlateException;
import com.switchfully.parkshark.exceptions.BadCreateMemberException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    private final Logger logger = LoggerFactory.getLogger(ValidationService.class);

    public boolean checkValid(String input) {
        return input != null && !input.isBlank() && !input.isEmpty();
    }

    public boolean assertCorrectCreateMemberDTO(CreateMemberDTO createMemberDTO) {
        var toCheck = checkValid(createMemberDTO.getFirstName()) && checkValid(createMemberDTO.getLastName()) && checkValid(createMemberDTO.getEmail()) && checkValid(createMemberDTO.getLicensePlateDTO().getLicensePlateNumber()) && checkValid(createMemberDTO.getLicensePlateDTO().getLicensePlateCountry()) && checkValid(createMemberDTO.getTelephoneNumber()) && assertCorrectCreateLicensePlateDTO(createMemberDTO.getLicensePlateDTO()) && assertCorrectCreateAddressDTO(createMemberDTO.getAddress());

        if (!toCheck) {
            logger.error("Data provided for new member invalid");
            throw new BadCreateMemberException();
        }

        return true;
    }

    public boolean assertCorrectCreateAddressDTO(CreateAddressDTO dto) {
        var toCheck = checkValid(dto.getZipcode()) && checkValid(dto.getCity()) && checkValid(dto.getStreet()) && checkValid(dto.getHouseNumber());

        if (!toCheck) {
            logger.error("Data provided for new member address invalid");
            throw new BadCreateAddressException();
        }

        return true;
    }

    public boolean assertCorrectCreateLicensePlateDTO(CreateLicensePlateDTO dto) {
        var toCheck = checkValid(dto.getLicensePlateCountry()) && checkValid(dto.getLicensePlateNumber());

        if (!toCheck) {
            logger.error("Data provided for new member address invalid");
            throw new BadCreateLicensePlateException();
        }

        return true;
    }

}
