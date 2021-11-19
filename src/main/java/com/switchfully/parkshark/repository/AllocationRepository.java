package com.switchfully.parkshark.repository;

import com.switchfully.parkshark.entity.Allocation;
import org.springframework.data.repository.CrudRepository;

public interface AllocationRepository extends CrudRepository<Allocation, Integer> {
}
