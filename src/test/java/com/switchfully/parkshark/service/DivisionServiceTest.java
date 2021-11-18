package com.switchfully.parkshark.service;

import com.switchfully.parkshark.dto.CreateDivisionDTO;
import com.switchfully.parkshark.dto.DivisionDTO;
import com.switchfully.parkshark.entity.Division;
import com.switchfully.parkshark.entity.Employee;
import com.switchfully.parkshark.mapper.DivisionMapper;
import com.switchfully.parkshark.repository.DivisionRepository;
import com.switchfully.parkshark.repository.EmployeeRepository;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DivisionServiceTest {

    @Autowired
    private DivisionService divisionService;
    private DivisionRepository divisionRepository;
    private EmployeeRepository employeeRepository;
    @Autowired
    private DivisionMapper divisionMapper;
    private CreateDivisionDTO createDivisionDTO;
    private Division division;
    private DivisionDTO divisionDTO;


    @BeforeEach
    void before() {
        divisionRepository = Mockito.mock(DivisionRepository.class);
        divisionService = new DivisionService(divisionRepository, divisionMapper, employeeRepository);
        createDivisionDTO = new CreateDivisionDTO("name 1",
                "original name 1",
                1,
                1);
        division = divisionMapper.toEntityDivision(createDivisionDTO);
        divisionDTO = divisionMapper.toDtoDivision(division);
    }

    @Test
    void givenADivisionService_whenSavingADivision_thenVerifySaveWithRepository() {
        divisionService.save(createDivisionDTO);
        Mockito.verify(divisionRepository).save(division);
    }

    @Test
    void givenADivisionService_whenAskingForAllDivisions_thenVerifyGetAllDivisionsWithRepository() {
        divisionService.getAllDivisions();
        Mockito.verify(divisionRepository).findAll();
    }

    @Test
    void givenADivisionService_whenSavingADivision_thenReturnAsDivisionDTO() {
        Mockito.when(divisionService.save(createDivisionDTO)).thenReturn(divisionDTO);
    }
}