package com.switchfully.parkshark.repository;

import com.switchfully.parkshark.entity.Allocation;
import com.switchfully.parkshark.entity.ParkingLot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AllocationRepositoryTest {

    @Autowired
    private AllocationRepository allocationRepositoryTest;

    @BeforeAll
    void setUp() {
        allocationRepositoryTest.save(new Allocation());

    }


    @Test
    public void findAll(){
        var toCheck = allocationRepositoryTest.findAll().size();
        Assertions.assertEquals(1, toCheck);


    }

    @Test
    public void findById(){
        var toCheck = allocationRepositoryTest.findAllocationByAllocationId(1);
        Assertions.assertNotNull(toCheck);

    }

    @Test
    public void save(){
        allocationRepositoryTest.save(new Allocation());
        var toCheck = allocationRepositoryTest.findAll().size();
        Assertions.assertEquals(2, toCheck);

    }




}