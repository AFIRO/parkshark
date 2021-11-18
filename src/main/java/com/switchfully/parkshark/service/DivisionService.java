package com.switchfully.parkshark.service;

import com.switchfully.parkshark.dto.CreateDivisionDTO;
import com.switchfully.parkshark.dto.DivisionDTO;
import com.switchfully.parkshark.entity.Division;
import com.switchfully.parkshark.exceptions.InvalidInputException;
import com.switchfully.parkshark.exceptions.NoSuchDivisionException;
import com.switchfully.parkshark.exceptions.NoSuchEmployeeException;
import com.switchfully.parkshark.mapper.DivisionMapper;
import com.switchfully.parkshark.repository.DivisionRepository;
import com.switchfully.parkshark.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DivisionService {

    private final DivisionRepository divisionRepository;
    private final EmployeeRepository employeeRepository;
    private final DivisionMapper divisionMapper;

    public DivisionService(DivisionRepository divisionRepository, DivisionMapper divisionMapper, EmployeeRepository employeeRepository) {
        this.divisionRepository = divisionRepository;
        this.divisionMapper = divisionMapper;
        this.employeeRepository = employeeRepository;
    }

    public DivisionDTO save(CreateDivisionDTO createDivisionDTO) {
        if(createDivisionDTO == null){
            throw new InvalidInputException();
        }
        if(createDivisionDTO.getDivision() != null){
            if(divisionRepository.findById(createDivisionDTO.getDivision()).isEmpty()){
                throw new NoSuchDivisionException();
            }
        }

        if(employeeRepository.findById(createDivisionDTO.getDirector()).isEmpty()){
            throw new NoSuchEmployeeException();
        }

        Division division = divisionMapper.toEntityDivision(createDivisionDTO);
        divisionRepository.save(division);
        return divisionMapper.toDtoDivision(division);
    }

    public List<DivisionDTO> getAllDivisions() {
        return divisionMapper.toDtoList(divisionRepository.findAll());
    }

    public DivisionDTO getDivision(int divisionid) {
        Optional<Division> optionalDivision = divisionRepository.findById(divisionid);
        if(optionalDivision.isEmpty()) throw new NoSuchDivisionException();
        return divisionMapper.toDtoDivision(optionalDivision.get());
    }
}
