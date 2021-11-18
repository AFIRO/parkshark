package com.switchfully.parkshark.mapper;

import com.switchfully.parkshark.dto.CreateDivisionDTO;
import com.switchfully.parkshark.dto.DivisionDTO;
import com.switchfully.parkshark.entity.Division;
import com.switchfully.parkshark.repository.DivisionRepository;
import com.switchfully.parkshark.repository.EmployeeRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DivisionMapper {

    private final DivisionRepository divisionRepository;
    private final EmployeeRepository employeeRepository;

    public DivisionMapper(DivisionRepository divisionRepository, EmployeeRepository employeeRepository) {
        this.divisionRepository = divisionRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<DivisionDTO> toDto(List<Division> divisionList) {
        return divisionList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Division toEntity(CreateDivisionDTO createDivisionDTO) {
        if(createDivisionDTO.getUpperDivision() != null){
            return new Division.Builder()
                    .withName(createDivisionDTO.getName())
                    .withOriginalName(createDivisionDTO.getOriginalName())
                    .withDirector(employeeRepository.findById(createDivisionDTO.getDirector()).get())
                    .withUpperDivision(divisionRepository.findById(createDivisionDTO.getUpperDivision()).get())
                    .build();
        } else {
            return new Division.Builder()
                    .withName(createDivisionDTO.getName())
                    .withOriginalName(createDivisionDTO.getOriginalName())
                    .withDirector(employeeRepository.findById(createDivisionDTO.getDirector()).get())
                    .build();
        }
    }

    public DivisionDTO toDto(Division division) {
        return new DivisionDTO.Builder()
                .withId(division.getId())
                .withName(division.getName())
                .withOriginalName(division.getOriginalName())
                .withEmployee(division.getDirector())
                .withDivision(division.getUpperDivision())
                .build();
    }

}
