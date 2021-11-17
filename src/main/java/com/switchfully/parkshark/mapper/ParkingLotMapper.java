package com.switchfully.parkshark.mapper;

import com.switchfully.parkshark.dto.CreateParkingLotDTO;
import com.switchfully.parkshark.dto.ParkingLotDTO;
import com.switchfully.parkshark.entity.ParkingLot;
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

        return ParkingLot.ParkingLotBuilder.aParkingLot()
                .withName(createParkingLotDTO.getName())
                .withMaxCapacity(createParkingLotDTO.getMaxCapacity())
                .withHourlyPrice(createParkingLotDTO.getHourlyPrice())
                .withCategory(categoryMapper.toEntity(createParkingLotDTO.getCategory()))
                .withParkingLotAddress(addressMapper.toEntity(createParkingLotDTO.getAddress()))
                .withEmployee(employeeMapper.toEntity(createParkingLotDTO.getEmployee()))
                .withDivision(divisionMapper.toEntityDivision(createParkingLotDTO.getDivision()))
                .build();
    }

    public ParkingLotDTO toDTO(ParkingLot parkingLot) {
        return ParkingLotDTO.ParkingLotDTOBuilder.aParkingLotDTO()
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
