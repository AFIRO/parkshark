package com.switchfully.parkshark.repository;

import com.switchfully.parkshark.entity.Allocation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AllocationRepository extends CrudRepository<Allocation, Integer> {

    Allocation findAllocationByAllocationId(int id);

    List<Allocation> findAll();
}
