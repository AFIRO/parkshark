package com.switchfully.parkshark.dto.parkinglot;


import com.switchfully.parkshark.dto.address.CreateAddressDTO;
import com.switchfully.parkshark.entity.ParkingLot;

public class CreateParkingLotDTO {

    private final String name;
    private final int maxCapacity;
    private final double hourlyPrice;
    private final ParkingLot.Category category;
    private final CreateAddressDTO address;
    private final Integer contactPerson;
    private final Integer division;

    private CreateParkingLotDTO(String name, int maxCapacity, double hourlyPrice, ParkingLot.Category category, CreateAddressDTO address, Integer contactPerson, Integer division) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.hourlyPrice = hourlyPrice;
        this.category = category;
        this.address = address;
        this.contactPerson = contactPerson;
        this.division = division;
    }

    public String getName() {
        return name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public double getHourlyPrice() {
        return hourlyPrice;
    }

    public ParkingLot.Category getCategory() {
        return category;
    }

    public Integer getContactPerson() {
        return contactPerson;
    }

    public Integer getDivision() {
        return division;
    }

    public CreateAddressDTO getAddress() {
        return address;
    }

}
