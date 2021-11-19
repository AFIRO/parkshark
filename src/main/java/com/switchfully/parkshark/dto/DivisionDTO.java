package com.switchfully.parkshark.dto;

import com.switchfully.parkshark.entity.Division;
import com.switchfully.parkshark.entity.Employee;

public class DivisionDTO {

    private final int divisionId;
    private final String name;
    private final String originalName;
    private final Employee director;
    private final Division upperDivision;

    public DivisionDTO(int divisionId, String name, String originalName, Employee director, Division upperDivision) {
        this.divisionId = divisionId;
        this.name = name;
        this.originalName = originalName;
        this.director = director;
        this.upperDivision = upperDivision;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public Employee getDirector() {
        return director;
    }

    public Division getUpperDivision() {
        return upperDivision;
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
