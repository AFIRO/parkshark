package com.switchfully.parkshark.service;

import com.switchfully.parkshark.dto.division.CreateDivisionDTO;
import com.switchfully.parkshark.dto.division.DivisionDTO;
import com.switchfully.parkshark.exceptions.division.NoSuchDivisionException;
import com.switchfully.parkshark.exceptions.employee.NoSuchEmployeeException;
import com.switchfully.parkshark.mapper.DivisionMapper;
import com.switchfully.parkshark.repository.DivisionRepository;
import com.switchfully.parkshark.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DivisionService {

    private final DivisionRepository divisionRepository;
    private final EmployeeRepository employeeRepository;
    private final DivisionMapper divisionMapper;
    private final ValidationService validation;
    private final Logger logger = LoggerFactory.getLogger(DivisionService.class);

    public DivisionService(DivisionRepository divisionRepository, DivisionMapper divisionMapper, EmployeeRepository employeeRepository, ValidationService validation) {
        this.divisionRepository = divisionRepository;
        this.divisionMapper = divisionMapper;
        this.employeeRepository = employeeRepository;
        this.validation = validation;
    }

    public DivisionDTO createDivision(CreateDivisionDTO createDivisionDTO) {
        validation.assertCorrectCreateDivisionDTO(createDivisionDTO);

        if(createDivisionDTO.getUpperDivision() != null){
            if(divisionRepository.findByDivisionId(createDivisionDTO.getUpperDivision()) == null){
                logger.error("Data provided for upper division invalid");
                throw new NoSuchDivisionException();
            }
        }
        if(createDivisionDTO.getDirector() == null || employeeRepository.findByEmployeeId(createDivisionDTO.getDirector())== null){
            logger.error("Data provided for director invalid");
            throw new NoSuchEmployeeException();
        }

        var newDivision = divisionMapper.toEntity(createDivisionDTO);
        logger.info("Data for create division valid");
        divisionRepository.save(newDivision);
        return divisionMapper.toDto(newDivision);
    }

    public List<DivisionDTO> getAllDivisions() {
        return divisionRepository.findAll()
                .stream()
                .map(divisionMapper::toDto)
                .collect(Collectors.toList());
    }

    public DivisionDTO getSpecificDivisionById(int divisionId) {
        var returnedDivision = divisionRepository.findByDivisionId(divisionId);
        if (returnedDivision == null) {
            logger.error("Non-existent division requested");
            throw new NoSuchDivisionException();
        }
        return divisionMapper.toDto(divisionRepository.findByDivisionId(divisionId));
    }
}
