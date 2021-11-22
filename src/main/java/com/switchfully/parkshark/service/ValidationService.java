package com.switchfully.parkshark.service;

import com.switchfully.parkshark.dto.address.CreateAddressDTO;
import com.switchfully.parkshark.dto.division.CreateDivisionDTO;
import com.switchfully.parkshark.dto.licenseplate.CreateLicensePlateDTO;
import com.switchfully.parkshark.dto.member.CreateMemberDTO;
import com.switchfully.parkshark.dto.parkinglot.CreateParkingLotDTO;
import com.switchfully.parkshark.exceptions.division.BadCreateDivisionException;
import com.switchfully.parkshark.exceptions.member.BadCreateAddressException;
import com.switchfully.parkshark.exceptions.member.BadCreateLicensePlateException;
import com.switchfully.parkshark.exceptions.member.BadCreateMemberException;
import com.switchfully.parkshark.exceptions.parkinglot.BadCreateParkingLotException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    private final Logger logger = LoggerFactory.getLogger(ValidationService.class);

    public boolean checkValid(String input) {
        return input != null && !input.isBlank() && !input.isEmpty();
    }

    public boolean checkValid(int input) {
        return input > 0;
    }

    public boolean checkValid(double input) {
        return input > 0;
    }

    public boolean assertCorrectCreateMemberDTO(CreateMemberDTO createMemberDTO) {
        var toCheck = checkValid(createMemberDTO.getFirstName())
                && checkValid(createMemberDTO.getLastName())
                && checkValid(createMemberDTO.getEmail())
                && checkValid(createMemberDTO.getLicensePlateDTO().getLicensePlateNumber())
                && checkValid(createMemberDTO.getLicensePlateDTO().getLicensePlateCountry())
                && checkValid(createMemberDTO.getTelephoneNumber())
                && assertCorrectCreateLicensePlateDTO(createMemberDTO.getLicensePlateDTO())
                && assertCorrectCreateAddressDTO(createMemberDTO.getAddress());

        if (!toCheck) {
            logger.error("Data provided for new member invalid");
            throw new BadCreateMemberException();
        }

        return true;
    }

    public boolean assertCorrectCreateAddressDTO(CreateAddressDTO createAddressDTO) {
        var toCheck = checkValid(createAddressDTO.getZipcode())
                && checkValid(createAddressDTO.getCity())
                && checkValid(createAddressDTO.getStreet())
                && checkValid(createAddressDTO.getHouseNumber());

        if (!toCheck) {
            logger.error("Data provided for new member address invalid");
            throw new BadCreateAddressException();
        }

        return true;
    }

    public boolean assertCorrectCreateLicensePlateDTO(CreateLicensePlateDTO createLicensePlateDTO) {
        var toCheck = checkValid(createLicensePlateDTO.getLicensePlateCountry())
                && checkValid(createLicensePlateDTO.getLicensePlateNumber());

        if (!toCheck) {
            logger.error("Data provided for new member address invalid");
            throw new BadCreateLicensePlateException();
        }

        return true;
    }

    public boolean assertCorrectCreateDivisionDTO(CreateDivisionDTO createDivisionDTO) {
        var toCheck = checkValid(createDivisionDTO.getName()) && checkValid(createDivisionDTO.getOriginalName());

        if (!toCheck) {
            logger.error("Data provided for new Division invalid");
            throw new BadCreateDivisionException();
        }

        return true;
    }

    public boolean assertCorrectCreateParkingLotDTO(CreateParkingLotDTO createParkingLotDTO) {
        var toCheck = checkValid(createParkingLotDTO.getName())
                && checkValid(createParkingLotDTO.getAddress().toString())
                && checkValid(createParkingLotDTO.getCategory().toString())
                && checkValid(createParkingLotDTO.getDivision().toString())
                && checkValid(createParkingLotDTO.getContactPerson().toString())
                && checkValid(createParkingLotDTO.getHourlyPrice())
                && checkValid(createParkingLotDTO.getMaxCapacity());

        if (!toCheck) {
            logger.error("Data provided for new parking lot invalid");
            throw new BadCreateParkingLotException();
        }

        return true;
    }

}
