package com.switchfully.parkshark.repository;

import com.switchfully.parkshark.entity.ParkingLot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ParkingLotRepository extends CrudRepository <ParkingLot, Integer>{

}