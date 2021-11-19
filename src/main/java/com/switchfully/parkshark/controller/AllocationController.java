package com.switchfully.parkshark.controller;

import com.switchfully.parkshark.dto.AllocationDTO;
import com.switchfully.parkshark.dto.CreateAllocationDTO;
import com.switchfully.parkshark.service.AllocationService;
import com.switchfully.parkshark.switchsecure.SecurityGuard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "allocations")
public class AllocationController {

    private final AllocationService allocationService;
    private final Logger logger = LoggerFactory.getLogger(AllocationController.class);

    @Autowired
    public AllocationController(AllocationService allocationService) {
        this.allocationService = allocationService;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @SecurityGuard(SecurityGuard.ApiUserRole.MANAGER)
    public List<AllocationDTO> getAllAllocations(@RequestParam(required = false) String status) {
        logger.info("Attempting to get all allocations.");
        return allocationService.getAllAllocations();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @SecurityGuard(SecurityGuard.ApiUserRole.CUSTOMER)
    public AllocationDTO startAllocation(@RequestBody CreateAllocationDTO createAllocationDTO){
        logger.info("Attempting to start allocation.");
        return allocationService.startAllocation(createAllocationDTO);
    }

    @PutMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @SecurityGuard(SecurityGuard.ApiUserRole.CUSTOMER)
    public AllocationDTO stopAllocation(@RequestParam int allocationId) {
        logger.info("Attempting to stop allocation.");
        return allocationService.stopAllocation(allocationId);
    }

}
