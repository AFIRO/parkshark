package com.switchfully.parkshark.dto.employee;

public class EmployeeUpperDivisionDTO {

    private final int directorId;
    private final String firstName;
    private final String lastName;

    public EmployeeUpperDivisionDTO(int directorId, String firstName, String lastName) {
        this.directorId = directorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getDirectorId() {
        return directorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public static final class Builder {
        private int directorId;
        private String firstName;
        private String lastName;

        public Builder withDirectorId(int directorId) {
            this.directorId = directorId;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public EmployeeUpperDivisionDTO build() {
            return new EmployeeUpperDivisionDTO(directorId, firstName, lastName);
        }
    }
}
