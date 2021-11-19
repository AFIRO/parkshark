package com.switchfully.parkshark.service;

import com.switchfully.parkshark.mapper.AllocationMapper;
import com.switchfully.parkshark.repository.AllocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AllocationService {
    private final AllocationRepository allocationRepository;
    private final AllocationMapper allocationMapper;

    public AllocationService(AllocationRepository allocationRepository, AllocationMapper allocationMapper){
        this.allocationRepository = allocationRepository;
        this.allocationMapper = allocationMapper;
    }
}
