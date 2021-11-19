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

    @Autowired
    public ParkingLotService(ParkingLotRepository parkingLotRepository, ParkingLotMapper parkingLotMapper) {
        this.parkingLotRepository = parkingLotRepository;
        this.parkingLotMapper = parkingLotMapper;
    }

    public List<ShortenedParkingLotDTO> getAllLots(){
        return parkingLotRepository.findAll()
                .stream()
                .map(parkingLotMapper::toShortenedDto)
                .collect(Collectors.toList());

    }


    public ParkingLotDTO createParkingLot(CreateParkingLotDTO createParkingLotDTO) {
        logger.info("attempting to create parking lot...");
        ParkingLot parkingLot = parkingLotMapper.toEntity(createParkingLotDTO);
        parkingLotRepository.save(parkingLot);
        return parkingLotMapper.toDto(parkingLot);
    }

    public ParkingLotDTO getSpecificLotById(int id) {
        logger.info("getting specific lot");
        var toCheck = parkingLotRepository.findById(id);
        if (toCheck.isEmpty())
            throw new NoSuchParkingLotException();

        return parkingLotMapper.toDto(toCheck.get());
    }


    //start van mogelijke validatiecode. Afwerkingen indien tijd genoeg.

//    private void assertValidCreateParkingLotDTO(CreateParkingLotDTO dto){
//        var toCheck = checkValid(dto.getName()) || assertCorrectCreateAddressDTO(dto.getAddress())
//    }

//    private boolean checkValid(String input) {
//        return !input.isBlank() && !input.isEmpty() && input != null;
//    }
//
//    private boolean checkValid(int input) {
//        return input> 0;
//    }
//
//    private boolean checkValid(double input) {
//        return input> 0;
//    }
//
//    private boolean assertCorrectCreateAddressDTO(CreateAddressDTO dto) {
//        var toCheck = checkValid(dto.getZipcode()) || checkValid(dto.getCity()) || checkValid(dto.getStreet()) || checkValid(dto.getHouseNumber());
//
//        if (!toCheck) {
//            logger.error("Data provided for new member address invalid");
//            throw new BadCreateAddressException();
//        }
//
//        return true;
//    }
}
