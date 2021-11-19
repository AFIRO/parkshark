package com.switchfully.parkshark.service;

import com.switchfully.parkshark.dto.division.CreateDivisionDTO;
import com.switchfully.parkshark.dto.employee.EmployeeUpperDivisionDTO;
import com.switchfully.parkshark.entity.Division;
import com.switchfully.parkshark.entity.Employee;
import com.switchfully.parkshark.mapper.DivisionMapper;
import com.switchfully.parkshark.mapper.EmployeeMapper;
import com.switchfully.parkshark.repository.DivisionRepository;
import com.switchfully.parkshark.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import java.util.ArrayList;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DivisionServiceIntegrationTest {

    private DivisionRepository divisionRepositoryMock;
    private DivisionService divisionService;
    private EmployeeRepository EmployeeRepositoryMock;

    private ValidationService validationService;
    private DivisionMapper divisionMapper;
    private EmployeeMapper employeeMapperMock;


    @BeforeAll
    void setup(){
        divisionRepositoryMock = Mockito.mock(DivisionRepository.class);
        EmployeeRepositoryMock =  Mockito.mock(EmployeeRepository.class);
        employeeMapperMock = Mockito.mock(EmployeeMapper.class);
        validationService = new ValidationService();
        divisionService  = new DivisionService(divisionRepositoryMock, new DivisionMapper(divisionRepositoryMock,EmployeeRepositoryMock,employeeMapperMock), EmployeeRepositoryMock, validationService);
        divisionMapper = new DivisionMapper(divisionRepositoryMock,EmployeeRepositoryMock,employeeMapperMock);
    }

    @Test
    void whenCreatingNewDivision_serviceReturnsExpectedDTO(){
        //given
        CreateDivisionDTO test = new CreateDivisionDTO("test","test",1, 1);
        Division testUpperDivision = new Division();
        Employee testEmployee = new Employee.Builder().withFirstName("test").withLastName("test").withEmail("test@test.be").build();
        Mockito.when(divisionRepositoryMock.findByDivisionId(1)).thenReturn(testUpperDivision);
        Mockito.when(EmployeeRepositoryMock.findByEmployeeId(1)).thenReturn(testEmployee);
        Mockito.when(employeeMapperMock.toDtoEmployeeUpperDivision(testEmployee)).thenReturn(new EmployeeUpperDivisionDTO(1,"test","test"));
        Division temp = divisionMapper.toEntity(test);
        var toCheckAgainst = divisionMapper.toDto(temp);

        //when
        var toCheck = divisionService.createDivision(test);

        //then
        Mockito.verify(divisionRepositoryMock).save(temp);
        Assertions.assertEquals(toCheck.getName(), toCheckAgainst.getName());
    }

    @Test
    void whenFindAllCalled_returnEmptyListAndCallRepo(){
        Mockito.when(divisionRepositoryMock.findAll()).thenReturn(new ArrayList<>());
        var toCheck = divisionService.getAllDivisions().size();

        Mockito.verify(divisionRepositoryMock).findAll();
        Assertions.assertEquals(0,toCheck);

    }

    @Test
    void whenFindSpecificIsCalled_expectedObjectisReturned(){
        var testDivision = new Division("test","test",new Employee(),new Division());
        Mockito.when(divisionRepositoryMock.findByDivisionId(1)).thenReturn(testDivision);
        var toCheckAgainst = divisionService.getSpecificDivisionById(1);
        var toCheck = divisionMapper.toDto(testDivision);

        //Mockito.verify(divisionRepositoryMock).findByDivisionId(1);
        Assertions.assertEquals(toCheck.getName(),toCheckAgainst.getName());

    }


}
