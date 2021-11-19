package com.switchfully.parkshark.controller;

import com.switchfully.parkshark.dto.division.CreateDivisionDTO;
import com.switchfully.parkshark.dto.division.DivisionDTO;
import com.switchfully.parkshark.service.DivisionService;
import com.switchfully.parkshark.switchsecure.SecurityGuard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "divisions")
public class DivisionController {

    private final DivisionService divisionService;
    private final Logger logger = LoggerFactory.getLogger(DivisionController.class);

    @Autowired
    public DivisionController(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @SecurityGuard(SecurityGuard.ApiUserRole.MANAGER)
    public List<DivisionDTO> getAllDivisions() {
        logger.info("Attempting to get all divisions.");
        return divisionService.getAllDivisions();
    }

    @GetMapping(path = "/{divisionId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @SecurityGuard(SecurityGuard.ApiUserRole.MANAGER)
    public DivisionDTO getDivision(@PathVariable int divisionId) {
        logger.info("Attempting to get a specific division called on division id: " + divisionId);
        return divisionService.getSpecificDivisionById(divisionId);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @SecurityGuard(SecurityGuard.ApiUserRole.MANAGER)
    public DivisionDTO createDivision(@RequestBody CreateDivisionDTO createDivisionDTO) {
        logger.info("Attempting to save a division.");
        return divisionService.createDivision(createDivisionDTO);
    }
}
