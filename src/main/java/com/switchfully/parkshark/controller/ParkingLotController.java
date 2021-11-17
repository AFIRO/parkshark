package com.switchfully.parkshark.controller;

import com.switchfully.parkshark.dto.CreateParkingLotDTO;
import com.switchfully.parkshark.dto.ParkingLotDTO;
import com.switchfully.parkshark.service.ParkingLotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/parkinglot")
public class ParkingLotController {
    private final ParkingLotService parkingLotService;
    private final Logger logger = LoggerFactory.getLogger(ParkingLotController.class);

    @Autowired
    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    //@SecurityGuard
    public ParkingLotDTO createParkingLot(@RequestBody CreateParkingLotDTO createParkingLotDTO) {
        logger.info("Attempting to create parking lot.");
        return parkingLotService.createParkingLot(createParkingLotDTO);
    }


}
