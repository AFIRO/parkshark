package com.switchfully.parkshark.dto.division;

import com.switchfully.parkshark.dto.employee.EmployeeDTO;

public class DivisionDTO {

    private final int divisionId;
    private final String name;
    private final String originalName;
    private final EmployeeDTO director;
    private final UpperDivisionDTO upperDivision;

    public DivisionDTO(int divisionId, String name, String originalName, EmployeeDTO director, UpperDivisionDTO upperDivision) {
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

    public EmployeeDTO getDirector() {
        return director;
    }

    public UpperDivisionDTO getUpperDivision() {
        return upperDivision;
    }


    public static final class Builder {
        private int id;
        private String name;
        private String originalName;
        private EmployeeDTO employee;
        private UpperDivisionDTO division;

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

        public Builder withEmployee(EmployeeDTO employee) {
            this.employee = employee;
            return this;
        }

        public Builder withUpperDivision(UpperDivisionDTO division) {
            this.division = division;
            return this;
        }

        public DivisionDTO build() {
            return new DivisionDTO(id, name, originalName, employee, division);
        }
    }
}
