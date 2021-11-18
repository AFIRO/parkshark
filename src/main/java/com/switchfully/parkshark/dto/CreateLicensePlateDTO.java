package com.switchfully.parkshark.dto;

public class CreateLicensePlateDTO {
    private String licensePlateNumber;
    private String licensePlateCountry;

    public CreateLicensePlateDTO(String licensePlateNumber, String licensePlateCountry) {
        this.licensePlateNumber = licensePlateNumber;
        this.licensePlateCountry = licensePlateCountry;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }


    public String getLicensePlateCountry() {
        return licensePlateCountry;
    }

}
