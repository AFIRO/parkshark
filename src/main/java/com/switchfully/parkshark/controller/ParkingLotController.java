package com.switchfully.parkshark.controller;

import com.switchfully.parkshark.dto.parkinglot.CreateParkingLotDTO;
import com.switchfully.parkshark.dto.parkinglot.ParkingLotDTO;
import com.switchfully.parkshark.dto.parkinglot.ShortenedParkingLotDTO;
import com.switchfully.parkshark.service.ParkingLotService;
import com.switchfully.parkshark.switchsecure.SecurityGuard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "parkinglot")
public class ParkingLotController {
    private final ParkingLotService parkingLotService;
    private final Logger logger = LoggerFactory.getLogger(ParkingLotController.class);

    @Autowired
    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @SecurityGuard(SecurityGuard.ApiUserRole.MANAGER)
    public ParkingLotDTO createParkingLot(@RequestBody CreateParkingLotDTO createParkingLotDTO) {
        logger.info("Attempting to create parking lot.");
        return parkingLotService.createParkingLot(createParkingLotDTO);
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @SecurityGuard(SecurityGuard.ApiUserRole.MANAGER)
    public List<ShortenedParkingLotDTO> getAllParkingLots() {
        logger.info("Attempting to get all parking lots.");
        return parkingLotService.getAllLots();
    }

    @GetMapping(path = "/{parkingLotId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @SecurityGuard(SecurityGuard.ApiUserRole.MANAGER)
    public ParkingLotDTO getSpecificParkingLot(@PathVariable int parkingLotId) {
        logger.info("Attempting to get a specific parking lot called on parkinglot id " + parkingLotId);
        return parkingLotService.getSpecificLotById(parkingLotId);
    }

}
