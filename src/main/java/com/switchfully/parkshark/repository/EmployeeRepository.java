package com.switchfully.parkshark.repository;

import com.switchfully.parkshark.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    List<Employee> findAll();

    Employee findByEmployeeId(int id);

}
