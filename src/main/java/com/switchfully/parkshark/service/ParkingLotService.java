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

import java.util.Optional;

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


    public ParkingLotDTO createParkingLot(CreateParkingLotDTO createParkingLotDTO) {
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
