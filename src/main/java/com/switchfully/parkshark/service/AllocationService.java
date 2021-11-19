package com.switchfully.parkshark.service;

import com.switchfully.parkshark.dto.AllocationDTO;
import com.switchfully.parkshark.dto.CreateAllocationDTO;
import com.switchfully.parkshark.entity.Allocation;
import com.switchfully.parkshark.exceptions.NoSuchAllocationException;
import com.switchfully.parkshark.mapper.AllocationMapper;
import com.switchfully.parkshark.repository.AllocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AllocationService {
    private final AllocationRepository allocationRepository;
    private final AllocationMapper allocationMapper;

    public AllocationService(AllocationRepository allocationRepository, AllocationMapper allocationMapper){
        this.allocationRepository = allocationRepository;
        this.allocationMapper = allocationMapper;
    }

    public List<AllocationDTO> getAllAllocations() {
        return allocationRepository.findAll().stream()
                .map(allocationMapper::toDto)
                .collect(Collectors.toList());
    }

    public AllocationDTO startAllocation(CreateAllocationDTO createAllocationDTO){
        Allocation allocation  = allocationMapper.toEntity(createAllocationDTO);
        allocationRepository.save(allocation);
        return allocationMapper.toDto(allocation);
    }

    public AllocationDTO stopAllocation(int allocationId) {
        Allocation allocation = allocationRepository.findAllocationByAllocationId(allocationId);

        if (allocation == null) throw new NoSuchAllocationException();

        allocation.stop();

        return allocationMapper.toDto(allocation);
    }
}
