package com.switchfully.parkshark.dto.employee;

import com.switchfully.parkshark.entity.Address;

public class ShortenedEmployeeDTO {

    private final int directorId;
    private final String firstName;
    private final String lastName;
    private final String mobileNumber;
    private final String telephoneNumber;
    private final String email;
    private final String empTitle;

    public ShortenedEmployeeDTO(int directorId, String firstName, String lastName, String mobileNumber, String telephoneNumber, String email, String empTitle) {
        this.directorId = directorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.empTitle = empTitle;
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getEmpTitle() {
        return empTitle;
    }


    public static final class Builder {
        private int directorId;
        private String firstName;
        private String lastName;
        private String mobileNumber;
        private String telephoneNumber;
        private String email;
        private String empTitle;

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

        public Builder withMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public Builder withTelephoneNumber(String telephoneNumber) {
            this.telephoneNumber = telephoneNumber;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withEmpTitle(String empTitle) {
            this.empTitle = empTitle;
            return this;
        }

        public ShortenedEmployeeDTO build() {
            return new ShortenedEmployeeDTO(directorId, firstName, lastName, mobileNumber, telephoneNumber, email, empTitle);
        }
    }
}
