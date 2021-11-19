package com.switchfully.parkshark.dto.member;

public class MemberDTO {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final String telephoneNumber;
    private final String email;
    private final String licensePlateNumber;
    private final String registrationDate;

    public MemberDTO(Integer id, String firstName, String lastName, String telephoneNumber, String email, String licensePlateNumber, String registrationDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.licensePlateNumber = licensePlateNumber;
        this.registrationDate = registrationDate;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public static class Builder {
        private Integer id;
        private String firstName;
        private String lastName;
        private String telephoneNumber;
        private String email;
        private String licensePlateNumber;
        private String registrationDate;


        public Builder withId(Integer id) {
            this.id = id;
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

        public Builder withTelephoneNumber(String telephoneNumber) {
            this.telephoneNumber = telephoneNumber;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withlicensePlateNumber(String licensePlateNumber) {
            this.licensePlateNumber = licensePlateNumber;
            return this;
        }

        public Builder withRegistrationDate(String registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public MemberDTO build() {
            return new MemberDTO(id, firstName, lastName, telephoneNumber, email, licensePlateNumber, registrationDate);
        }

    }



}
