package com.switchfully.parkshark.repository;

import com.switchfully.parkshark.entity.ParkingLot;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParkingLotRepository extends CrudRepository<ParkingLot, Integer> {

    ParkingLot findParkingLotByParkingLotId(int id);

    List<ParkingLot> findAll();
}