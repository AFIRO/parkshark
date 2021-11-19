package com.switchfully.parkshark.service;

import com.switchfully.parkshark.entity.Division;
import com.switchfully.parkshark.repository.DivisionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
public class DivisionServiceIntegrationTest {

    @Autowired
    private DivisionRepository divisionRepository;



    @Test
    @Sql("data.sql")
    void testingSQLscript() {
        List<Division> result = divisionRepository.findAll();

        Assertions.assertEquals(1, result.size());
    }
}
