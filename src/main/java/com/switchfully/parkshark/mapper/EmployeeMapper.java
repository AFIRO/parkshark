package com.switchfully.parkshark.mapper;


import com.switchfully.parkshark.dto.CreateEmployeeDTO;
import com.switchfully.parkshark.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public Employee toEntity(CreateEmployeeDTO createEmployeeDTO) {
        return Employee.EmployeeBuilder.anEmployee()
                .withFirstName(createEmployeeDTO.getFirstName())
                .withLastName(createEmployeeDTO.getLastName())
                .withMobileNumber(createEmployeeDTO.getMobileNumber())
                .withTelephoneNumber(createEmployeeDTO.getTelephoneNumber())
                .withAddress(createEmployeeDTO.getAddress())
                .withEmail(createEmployeeDTO.getEmail())
                .withEmpTitle(createEmployeeDTO.getEmpTitle())
                .build();
    }
}
