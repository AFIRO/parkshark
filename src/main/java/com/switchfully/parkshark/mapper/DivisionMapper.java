package com.switchfully.parkshark.mapper;

import com.switchfully.parkshark.dto.CreateDivisionDTO;
import com.switchfully.parkshark.dto.DivisionDTO;
import com.switchfully.parkshark.entity.Division;
import com.switchfully.parkshark.repository.DivisionRepository;
import com.switchfully.parkshark.repository.EmployeeRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DivisionMapper {

    private DivisionRepository divisionRepository;
    private EmployeeRepository employeeRepository;

    public DivisionMapper(DivisionRepository divisionRepository, EmployeeRepository employeeRepository) {
        this.divisionRepository = divisionRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<DivisionDTO> toDtoList(List<Division> divisionList) {
        return divisionList.stream().map(this::toDtoDivision).collect(Collectors.toList());
    }

    public Division toEntityDivision(CreateDivisionDTO createDivisionDTO) {
        if(createDivisionDTO.getDivision() != null){
            return new Division.DivisionBuilder()
                    .setName(createDivisionDTO.getName())
                    .setOriginalName(createDivisionDTO.getOriginalName())
                    .setEmployee(employeeRepository.findById(createDivisionDTO.getDirector()).get())
                    .setDivision(divisionRepository.findById(createDivisionDTO.getDivision()).get())
                    .build();
        } else {
            return new Division.DivisionBuilder()
                    .setName(createDivisionDTO.getName())
                    .setOriginalName(createDivisionDTO.getOriginalName())
                    .setEmployee(employeeRepository.findById(createDivisionDTO.getDirector()).get())
                    .build();
        }
    }

    public DivisionDTO toDtoDivision(Division division) {
        return new DivisionDTO.DivisionDTOBuilder()
                .setId(division.getId())
                .setName(division.getName())
                .setOriginalName(division.getOriginalName())
                .setEmployee(division.getDirector())
                .setDivision(division.getUpperDivision())
                .build();
    }

}
