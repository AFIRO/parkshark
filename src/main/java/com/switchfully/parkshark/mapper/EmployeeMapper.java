package com.switchfully.parkshark.mapper;


import com.switchfully.parkshark.dto.employee.CreateEmployeeDTO;
import com.switchfully.parkshark.dto.employee.EmployeeDTO;
import com.switchfully.parkshark.dto.employee.EmployeeUpperDivisionDTO;
import com.switchfully.parkshark.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public Employee toEntity(CreateEmployeeDTO createEmployeeDTO) {
        return new Employee.Builder()
                .withFirstName(createEmployeeDTO.getFirstName())
                .withLastName(createEmployeeDTO.getLastName())
                .withMobileNumber(createEmployeeDTO.getMobileNumber())
                .withTelephoneNumber(createEmployeeDTO.getTelephoneNumber())
                .withAddress(createEmployeeDTO.getAddress())
                .withEmail(createEmployeeDTO.getEmail())
                .withEmpTitle(createEmployeeDTO.getEmpTitle())
                .build();
    }

    public EmployeeDTO toDto(Employee employee) {
        return new EmployeeDTO.Builder()
                .withDirectorId(employee.getEmployeeId())
                .withFirstName(employee.getFirstName())
                .withLastName(employee.getLastName())
                .withTelephoneNumber(employee.getTelephoneNumber())
                .withMobileNumber(employee.getMobileNumber())
                .withEmail(employee.getEmail())
                .withAddress(employee.getAddress())
                .withParkingLot(employee.getParkingLot())
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
