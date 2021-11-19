package com.switchfully.parkshark.repository;

import com.switchfully.parkshark.entity.Member;
import com.switchfully.parkshark.entity.ParkingLot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ParkingLotRepositoryTest {

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @BeforeAll
    void setUp() {
        parkingLotRepository.save(new ParkingLot());

    }


    @Test
    public void findAll(){
        var toCheck = parkingLotRepository.findAll().size();
        Assertions.assertEquals(1, toCheck);


    }

    @Test
    public void findById(){
        var toCheck = parkingLotRepository.findById(1);
        Assertions.assertNotNull(toCheck);

    }

    @Test
    public void save(){
        parkingLotRepository.save(new ParkingLot());
        var toCheck = parkingLotRepository.findAll().size();
        Assertions.assertEquals(2, toCheck);

    }




}