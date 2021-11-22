package com.switchfully.parkshark.mapper;

import com.switchfully.parkshark.dto.division.CreateDivisionDTO;
import com.switchfully.parkshark.dto.division.DivisionDTO;
import com.switchfully.parkshark.dto.division.UpperDivisionDTO;
import com.switchfully.parkshark.entity.Division;
import com.switchfully.parkshark.repository.DivisionRepository;
import com.switchfully.parkshark.repository.EmployeeRepository;
import org.springframework.stereotype.Component;

@Component
public class DivisionMapper {

    private final DivisionRepository divisionRepository;
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public DivisionMapper(DivisionRepository divisionRepository, EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.divisionRepository = divisionRepository;
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }


    public Division toEntity(CreateDivisionDTO createDivisionDTO) {
        if (createDivisionDTO.getUpperDivision() != null) {
            return new Division.Builder()
                    .withName(createDivisionDTO.getName())
                    .withOriginalName(createDivisionDTO.getOriginalName())
                    .withDirector(employeeRepository.findByEmployeeId(createDivisionDTO.getDirector()))
                    .withUpperDivision(divisionRepository.findByDivisionId(createDivisionDTO.getUpperDivision()))
                    .build();
        } else {
            return new Division.Builder()
                    .withName(createDivisionDTO.getName())
                    .withOriginalName(createDivisionDTO.getOriginalName())
                    .withDirector(employeeRepository.findByEmployeeId(createDivisionDTO.getDirector()))
                    .build();
        }
    }

    public DivisionDTO toDto(Division division) {
        return new DivisionDTO.Builder()
                .withId(division.getDivisionId())
                .withName(division.getName())
                .withOriginalName(division.getOriginalName())
                .withEmployee(employeeMapper.toDtoShortenedEmployee(division.getDirector()))
                .withUpperDivision(toDtoUpperDivision(division.getUpperDivision()))
                .build();
    }

    public UpperDivisionDTO toDtoUpperDivision(Division upperDivision) {
        if (upperDivision == null) {
            return null;
        }
        return new UpperDivisionDTO.Builder()
                .withDivisionId(upperDivision.getDivisionId())
                .withName(upperDivision.getName())
                .withDirector(employeeMapper.toDtoEmployeeUpperDivision(upperDivision.getDirector()))
                .build();
    }


}
