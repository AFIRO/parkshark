package com.switchfully.parkshark.mapper;

import com.switchfully.parkshark.dto.CreateParkingLotDTO;
import com.switchfully.parkshark.dto.ParkingLotDTO;
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
    private final EmployeeMapper employeeMapper;
    private final DivisionMapper divisionMapper;
    private final CategoryMapper categoryMapper;

    @Autowired
    public ParkingLotMapper(AddressMapper addressMapper, EmployeeMapper employeeMapper, DivisionMapper divisionMapper, CategoryMapper categoryMapper) {
        this.addressMapper = addressMapper;
        this.employeeMapper = employeeMapper;
        this.divisionMapper = divisionMapper;
        this.categoryMapper = categoryMapper;
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
                .withName(parkingLot.getName())
                .withMaxCapacity(parkingLot.getMaxCapacity())
                .withHourlyPrice(parkingLot.getHourlyPrice())
                .withCategory(parkingLot.getCategory())
                .withParkingLotAddress(parkingLot.getParkingLotAddress())
                .withEmployee(parkingLot.getEmployee())
                .withDivision(parkingLot.getDivision())
                .build();
    }
}
