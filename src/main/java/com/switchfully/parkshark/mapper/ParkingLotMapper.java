package com.switchfully.parkshark.mapper;

import com.switchfully.parkshark.dto.CreateParkingLotDTO;
import com.switchfully.parkshark.dto.ParkingLotDTO;
import com.switchfully.parkshark.dto.ShortenedParkingLotDTO;
import com.switchfully.parkshark.entity.ParkingLot;
import com.switchfully.parkshark.exceptions.NoSuchDivisionException;
import com.switchfully.parkshark.exceptions.NoSuchEmployeeException;
import com.switchfully.parkshark.repository.DivisionRepository;
import com.switchfully.parkshark.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotMapper {

    private final AddressMapper addressMapper;
    private final EmployeeRepository employeeRepository;
    private final DivisionRepository divisionRepository;

    @Autowired
    public ParkingLotMapper(AddressMapper addressMapper, EmployeeRepository employeeRepository, DivisionRepository divisionRepository) {
        this.addressMapper = addressMapper;
        this.employeeRepository = employeeRepository;
        this.divisionRepository = divisionRepository;
    }

    public ParkingLot toEntity(CreateParkingLotDTO createParkingLotDTO) {
        var toCheckEmployee = employeeRepository.findById(createParkingLotDTO.getEmployee());
        var toCheckDivision = divisionRepository.findById(createParkingLotDTO.getDivision());

        if (toCheckDivision.isEmpty())
            throw new NoSuchDivisionException();

        if (toCheckEmployee.isEmpty())
            throw new NoSuchEmployeeException();

        return new ParkingLot.ParkingLotBuilder()
                .withName(createParkingLotDTO.getName())
                .withMaxCapacity(createParkingLotDTO.getMaxCapacity())
                .withHourlyPrice(createParkingLotDTO.getHourlyPrice())
                .withCategory(createParkingLotDTO.getCategory())
                .withParkingLotAddress(addressMapper.toEntity(createParkingLotDTO.getAddress()))
                .withEmployee(toCheckEmployee.get())
                .withDivision(toCheckDivision.get())
                .build();


    }

    public ParkingLotDTO toDTO(ParkingLot parkingLot) {
        return new ParkingLotDTO.ParkingLotDTOBuilder()
                .withParkingLotId(parkingLot.getParkingLotId())
                .withName(parkingLot.getName())
                .withMaxCapacity(parkingLot.getMaxCapacity())
                .withHourlyPrice(parkingLot.getHourlyPrice())
                .withCategory(parkingLot.getCategory())
                .withParkingLotAddress(parkingLot.getParkingLotAddress())
                .withEmployee(parkingLot.getEmployee())
                .withDivision(parkingLot.getDivision())
                .build();
    }

    public ShortenedParkingLotDTO toShortenedDTO(ParkingLot parkingLot) {
        return new ShortenedParkingLotDTO.ParkingLotDTOBuilder()
                .withName(parkingLot.getName())
                .withMaxCapacity(parkingLot.getMaxCapacity())
                .withParkingLotId(parkingLot.getParkingLotId())
                .withEmployeeEmail(parkingLot.getEmployee().getEmail())
                .withEmployeeTelephoneNumber(parkingLot.getEmployee().getTelephoneNumber())
                .build();
    }
}
