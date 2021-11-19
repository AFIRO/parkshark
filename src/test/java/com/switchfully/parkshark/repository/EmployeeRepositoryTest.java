package com.switchfully.parkshark.repository;

import com.switchfully.parkshark.entity.Division;
import com.switchfully.parkshark.entity.Employee;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Collections;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        employeeRepository.save(new Employee());

    }



    @Test
    public void findAll(){
        var toCheck = employeeRepository.findAll().size();
        Assertions.assertEquals(1, toCheck);

    }

    @Test
    public void findById(){
        var toCheck = employeeRepository.findById(1);
        Assertions.assertNotNull(toCheck);

    }

    @Test
    public void save(){
        employeeRepository.save(new Employee());
        var toCheck = Lists.list(employeeRepository.findAll()).size() ;
        Assertions.assertEquals(1, toCheck);

    }




}