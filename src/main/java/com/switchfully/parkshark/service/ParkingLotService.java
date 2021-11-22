package com.switchfully.parkshark.service;

import com.switchfully.parkshark.dto.parkinglot.CreateParkingLotDTO;
import com.switchfully.parkshark.dto.parkinglot.ParkingLotDTO;
import com.switchfully.parkshark.dto.parkinglot.ShortenedParkingLotDTO;
import com.switchfully.parkshark.entity.ParkingLot;
import com.switchfully.parkshark.exceptions.parkinglot.NoSuchParkingLotException;
import com.switchfully.parkshark.mapper.ParkingLotMapper;
import com.switchfully.parkshark.repository.ParkingLotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ParkingLotService {

    private final ParkingLotRepository parkingLotRepository;
    private final ParkingLotMapper parkingLotMapper;
    private final Logger logger = LoggerFactory.getLogger(ParkingLotService.class);
    private final ValidationService validationService;

    @Autowired
    public ParkingLotService(ParkingLotRepository parkingLotRepository, ParkingLotMapper parkingLotMapper, ValidationService validationService) {
        this.parkingLotRepository = parkingLotRepository;
        this.parkingLotMapper = parkingLotMapper;
        this.validationService = validationService;
    }

    public List<ShortenedParkingLotDTO> getAllLots() {
        return parkingLotRepository.findAll()
                .stream()
                .map(parkingLotMapper::toShortenedDto)
                .collect(Collectors.toList());

    }

    public ParkingLotDTO createParkingLot(CreateParkingLotDTO createParkingLotDTO) {
        validationService.assertCorrectCreateParkingLotDTO(createParkingLotDTO);
        logger.info("Data for creating parking lot valid.");
        ParkingLot parkingLot = parkingLotMapper.toEntity(createParkingLotDTO);
        parkingLotRepository.save(parkingLot);
        return parkingLotMapper.toDto(parkingLot);
    }

    public ParkingLotDTO getSpecificLotById(int parkingLotId) {
        var toCheck = parkingLotRepository.findById(parkingLotId);
        if (toCheck.isEmpty())
            throw new NoSuchParkingLotException();

        return parkingLotMapper.toDto(toCheck.get());
    }
}
