package com.switchfully.parkshark.dto.division;

import com.switchfully.parkshark.dto.employee.EmployeeUpperDivisionDTO;

public class UpperDivisionDTO {

    private final int divisionId;
    private final String name;
    private final EmployeeUpperDivisionDTO director;

    public UpperDivisionDTO(int divisionId, String name, EmployeeUpperDivisionDTO director) {
        this.divisionId = divisionId;
        this.name = name;
        this.director = director;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public String getName() {
        return name;
    }

    public EmployeeUpperDivisionDTO getDirector() {
        return director;
    }


    public static final class Builder {
        private int divisionId;
        private String name;
        private EmployeeUpperDivisionDTO director;

        public Builder withDivisionId(int divisionId) {
            this.divisionId = divisionId;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDirector(EmployeeUpperDivisionDTO director) {
            this.director = director;
            return this;
        }

        public UpperDivisionDTO build() {
            return new UpperDivisionDTO(divisionId, name, director);
        }
    }
}
