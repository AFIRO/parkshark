package com.switchfully.parkshark.dto.member;

import com.switchfully.parkshark.dto.address.CreateAddressDTO;
import com.switchfully.parkshark.dto.licenseplate.CreateLicensePlateDTO;
import com.switchfully.parkshark.entity.Member;

import java.time.LocalDate;

public class CreateMemberDTO {
    private String firstName;
    private String lastName;
    private CreateAddressDTO address;
    private String telephoneNumber;
    private String email;
    private CreateLicensePlateDTO licensePlateDTO;
    private final LocalDate registrationDate;

    public CreateMemberDTO(String firstName, String lastName, CreateAddressDTO address, String telephoneNumber, String email, CreateLicensePlateDTO licensePlateDTO, Member.MembershipLevel membershipLevel, LocalDate registrationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.licensePlateDTO = licensePlateDTO;
        this.registrationDate = registrationDate;
    }

    public CreateMemberDTO() {
        this.registrationDate = LocalDate.now();
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


    public CreateLicensePlateDTO getLicensePlateDTO() {
        return licensePlateDTO;
    }


    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public CreateAddressDTO getAddress() {
        return address;
    }

}
