package com.switchfully.parkshark.mapper;

import com.switchfully.parkshark.dto.parkinglot.CreateParkingLotDTO;
import com.switchfully.parkshark.dto.parkinglot.ParkingLotDTO;
import com.switchfully.parkshark.dto.parkinglot.ShortenedParkingLotDTO;
import com.switchfully.parkshark.entity.ParkingLot;
import com.switchfully.parkshark.exceptions.division.NoSuchDivisionException;
import com.switchfully.parkshark.exceptions.employee.NoSuchEmployeeException;
import com.switchfully.parkshark.repository.DivisionRepository;
import com.switchfully.parkshark.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotMapper {

    private final AddressMapper addressMapper;
    private final EmployeeRepository employeeRepository;
    private final DivisionRepository divisionRepository;
    private final DivisionMapper divisionMapper;
    private final EmployeeMapper employeeMapper;

    @Autowired
    public ParkingLotMapper(AddressMapper addressMapper, EmployeeRepository employeeRepository, DivisionRepository divisionRepository, DivisionMapper divisionMapper, EmployeeMapper employeeMapper) {
        this.addressMapper = addressMapper;
        this.employeeRepository = employeeRepository;
        this.divisionRepository = divisionRepository;
        this.divisionMapper = divisionMapper;
        this.employeeMapper = employeeMapper;
    }

    public ParkingLot toEntity(CreateParkingLotDTO createParkingLotDTO) {
        var toCheckEmployee = employeeRepository.findByEmployeeId(createParkingLotDTO.getContactPerson());
        var toCheckDivision = divisionRepository.findByDivisionId(createParkingLotDTO.getDivision());

        if (toCheckDivision == null)
            throw new NoSuchDivisionException();

        if (toCheckEmployee == null)
            throw new NoSuchEmployeeException();

        return new ParkingLot.Builder()
                .withName(createParkingLotDTO.getName())
                .withMaxCapacity(createParkingLotDTO.getMaxCapacity())
                .withHourlyPrice(createParkingLotDTO.getHourlyPrice())
                .withCategory(createParkingLotDTO.getCategory())
                .withParkingLotAddress(addressMapper.toEntity(createParkingLotDTO.getAddress()))
                .withEmployee(toCheckEmployee)
                .withDivision(toCheckDivision)
                .build();


    }

    public ParkingLotDTO toDto(ParkingLot parkingLot) {
        return new ParkingLotDTO.Builder()
                .withParkingLotId(parkingLot.getParkingLotId())
                .withName(parkingLot.getName())
                .withMaxCapacity(parkingLot.getMaxCapacity())
                .withHourlyPrice(parkingLot.getHourlyPrice())
                .withCategory(parkingLot.getCategory())
                .withParkingLotAddress(addressMapper.toDto(parkingLot.getParkingLotAddress()))
                .withEmployee(employeeMapper.toDto(parkingLot.getEmployee()))
                .withDivision(divisionMapper.toDto(parkingLot.getDivision()))
                .build();
    }

    public ShortenedParkingLotDTO toShortenedDto(ParkingLot parkingLot) {
        return new ShortenedParkingLotDTO.Builder()
                .withName(parkingLot.getName())
                .withMaxCapacity(parkingLot.getMaxCapacity())
                .withParkingLotId(parkingLot.getParkingLotId())
                .withEmployeeEmail(parkingLot.getEmployee().getEmail())
                .withEmployeeTelephoneNumber(parkingLot.getEmployee().getTelephoneNumber())
                .build();
    }
}
