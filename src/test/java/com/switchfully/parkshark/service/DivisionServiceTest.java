package com.switchfully.parkshark.service;

import com.switchfully.parkshark.dto.CreateDivisionDTO;
import com.switchfully.parkshark.dto.DivisionDTO;
import com.switchfully.parkshark.entity.Division;
import com.switchfully.parkshark.exceptions.InvalidInputException;
import com.switchfully.parkshark.mapper.DivisionMapper;
import com.switchfully.parkshark.repository.DivisionRepository;
import com.switchfully.parkshark.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@SpringBootTest
class DivisionServiceTest {

    private DivisionService divisionService;
    private DivisionRepository divisionRepository;
    private EmployeeRepository employeeRepository;

    private DivisionMapper divisionMapper;
    private CreateDivisionDTO createDivisionDTO;
    private Division division;
    private DivisionDTO divisionDTO;


    @BeforeEach
    void before() {
        divisionRepository = Mockito.mock(DivisionRepository.class);
        employeeRepository = Mockito.mock(EmployeeRepository.class);
        divisionMapper = Mockito.mock(DivisionMapper.class);
        divisionService = new DivisionService(divisionRepository, divisionMapper, employeeRepository);
//        createDivisionDTO = new CreateDivisionDTO("name 1",
//                "original name 1",
//                1,
//                1);
        division = divisionMapper.toEntity(createDivisionDTO);
        divisionDTO = divisionMapper.toDto(division);
    }


    @Test
    void givenADivisionService_whenAskingForAllDivisions_thenVerifyGetAllDivisionsWithRepository() {
        divisionService.getAllDivisions();
        Mockito.verify(divisionRepository).findAll();
    }

    @Test
    void givenDivisionService_whenSavingANullObject_thenThrowInvalidInputException(){
        CreateDivisionDTO createDivisionDTO = null;

        Assertions.assertThrows(InvalidInputException.class, () -> divisionService.createDivision(null));
    }


    //////////////////////////////////////////
    //INTEGRATION TEST

//    @Test
//    void givenADivisionService_whenSavingADivision_thenReturnAsDivisionDTO() {
//        Mockito.when(divisionService.save(createDivisionDTO)).thenReturn(divisionDTO);
//    }
//
//    @Test
//    void givenADivisionService_whenSavingADivision_thenVerifySaveWithRepository() {
//        divisionService.save(createDivisionDTO);
//        Mockito.verify(divisionRepository).save(division);
//    }


}