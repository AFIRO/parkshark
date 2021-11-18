package com.switchfully.parkshark.repository;

import com.switchfully.parkshark.entity.Division;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DivisionRepository extends CrudRepository<Division, Integer> {

    Division findByDivisionId(int id);
    List<Division> findAll();
}
