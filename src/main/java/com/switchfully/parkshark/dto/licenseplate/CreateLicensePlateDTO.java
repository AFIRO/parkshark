package com.switchfully.parkshark.dto.licenseplate;

public class CreateLicensePlateDTO {
    private final String licensePlateNumber;
    private final String licensePlateCountry;

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
