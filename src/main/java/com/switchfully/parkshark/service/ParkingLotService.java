package com.switchfully.parkshark.service;

import com.switchfully.parkshark.dto.CreateParkingLotDTO;
import com.switchfully.parkshark.dto.ParkingLotDTO;
import com.switchfully.parkshark.entity.Category;
import com.switchfully.parkshark.entity.ParkingLot;
import com.switchfully.parkshark.exceptions.CategoryAlreadyExistsException;
import com.switchfully.parkshark.mapper.ParkingLotMapper;
import com.switchfully.parkshark.repository.CategoryRepository;
import com.switchfully.parkshark.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ParkingLotService {

    private final ParkingLotRepository parkingLotRepository;
    private final CategoryRepository categoryRepository;
    private final ParkingLotMapper parkingLotMapper;

    @Autowired
    public ParkingLotService(ParkingLotRepository parkingLotRepository, CategoryRepository categoryRepository, ParkingLotMapper parkingLotMapper) {
        this.parkingLotRepository = parkingLotRepository;
        this.categoryRepository = categoryRepository;
        this.parkingLotMapper = parkingLotMapper;
    }

    public List<ParkingLotDTO> getAllLots(){
        return parkingLotRepository.findAll()
                .stream()
                .map(parkingLotMapper::toDTO)
                .collect(Collectors.toList());

    }


    public ParkingLotDTO createParkingLot(CreateParkingLotDTO createParkingLotDTO) {
        logger.info("attempting to create parkinglot...");
        ParkingLot parkingLot = parkingLotMapper.toEntity(createParkingLotDTO);
        assertThatCategoryDoesNotExistYet(parkingLot.getCategory().getCategoryName());
        ParkingLot savedParkingLot = parkingLotRepository.save(parkingLot);
        return parkingLotMapper.toDTO(savedParkingLot);
    }

    private void assertThatCategoryDoesNotExistYet(String categoryName) {
        Optional<Category> categoryPresent = categoryRepository.findByCategoryNameEquals(categoryName);
        if(categoryPresent.isPresent()){
            throw new CategoryAlreadyExistsException();
        }
    }
}
