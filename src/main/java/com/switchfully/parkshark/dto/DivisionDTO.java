package com.switchfully.parkshark.dto;

import com.switchfully.parkshark.entity.Division;
import com.switchfully.parkshark.entity.Employee;

public class DivisionDTO {

    private final int id;
    private final String name;
    private final String originalName;
    private final Employee employee;
    private final Division division;

    public DivisionDTO(int id, String name, String originalName, Employee employee, Division division) {
        this.id = id;
        this.name = name;
        this.originalName = originalName;
        this.employee = employee;
        this.division = division;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Division getDivision() {
        return division;
    }


    public static final class Builder {
        private int id;
        private String name;
        private String originalName;
        private Employee employee;
        private Division division;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withOriginalName(String originalName) {
            this.originalName = originalName;
            return this;
        }

        public Builder withEmployee(Employee employee) {
            this.employee = employee;
            return this;
        }

        public Builder withDivision(Division division) {
            this.division = division;
            return this;
        }

        public DivisionDTO build() {
            return new DivisionDTO(id, name, originalName, employee, division);
        }
    }
}
