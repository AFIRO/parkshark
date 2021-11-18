package com.switchfully.parkshark.repository;

import com.switchfully.parkshark.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
