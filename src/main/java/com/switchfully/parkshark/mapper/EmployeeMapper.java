package com.switchfully.parkshark.mapper;


import com.switchfully.parkshark.dto.employee.EmployeeDTO;
import com.switchfully.parkshark.dto.employee.EmployeeUpperDivisionDTO;
import com.switchfully.parkshark.dto.employee.ShortenedEmployeeDTO;
import com.switchfully.parkshark.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {


    public EmployeeDTO toDto(Employee employee) {
        return new EmployeeDTO.Builder()
                .withDirectorId(employee.getEmployeeId())
                .withFirstName(employee.getFirstName())
                .withLastName(employee.getLastName())
                .withTelephoneNumber(employee.getTelephoneNumber())
                .withMobileNumber(employee.getMobileNumber())
                .withEmail(employee.getEmail())
                .withAddress(employee.getAddress())
                .withEmpTitle(employee.getEmpTitle())
                .build();
    }

    public ShortenedEmployeeDTO toDtoShortenedEmployee(Employee employee){
        return new ShortenedEmployeeDTO.Builder()
                .withDirectorId(employee.getEmployeeId())
                .withFirstName(employee.getFirstName())
                .withLastName(employee.getLastName())
                .withTelephoneNumber(employee.getTelephoneNumber())
                .withMobileNumber(employee.getMobileNumber())
                .withEmail(employee.getEmail())
                .withEmpTitle(employee.getEmpTitle())
                .build();
    }

    public EmployeeUpperDivisionDTO toDtoEmployeeUpperDivision(Employee employee) {
        return new EmployeeUpperDivisionDTO.Builder()
                .withDirectorId(employee.getEmployeeId())
                .withFirstName(employee.getFirstName())
                .withLastName(employee.getLastName())
                .build();
    }
}
