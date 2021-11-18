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

    public DivisionDTO createDivision(CreateDivisionDTO createDivisionDTO) {
        if(createDivisionDTO == null){
            throw new InvalidInputException();
        }
        if(createDivisionDTO.getUpperDivision() != null){
            if(divisionRepository.findById(createDivisionDTO.getUpperDivision()).isEmpty()){
                throw new NoSuchDivisionException();
            }
        }

        if(employeeRepository.findById(createDivisionDTO.getDirector()).isEmpty()){
            throw new NoSuchEmployeeException();
        }

        Division division = divisionMapper.toEntity(createDivisionDTO);
        divisionRepository.save(division);
        return divisionMapper.toDto(division);
    }

    public List<DivisionDTO> getAllDivisions() {
        return divisionMapper.toDto(divisionRepository.findAll());
    }

    public DivisionDTO getSpecificDivisionById(int divisionid) {
        var returnedDivision = divisionRepository.findByDivisionId(divisionid);
        if (returnedDivision == null) {
//            logger.error("Non-existent member requested");
            throw new NoSuchDivisionException();
        }
        return divisionMapper.toDto(divisionRepository.findByDivisionId(divisionid));
    }
}
