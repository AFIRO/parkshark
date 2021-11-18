package com.switchfully.parkshark.dto;


public class CreateParkingLotDTO {

    private final String name;
    private final int maxCapacity;
    private final double hourlyPrice;
    private final CreateCategoryDTO category;
    private final CreateAddressDTO address;
    private final CreateEmployeeDTO employee;
    private final CreateDivisionDTO division;

    private CreateParkingLotDTO(String name, int maxCapacity, double hourlyPrice, CreateCategoryDTO category, CreateAddressDTO address, CreateEmployeeDTO employee, CreateDivisionDTO division) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.hourlyPrice = hourlyPrice;
        this.category = category;
        this.address = address;
        this.employee = employee;
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

    public CreateCategoryDTO getCategory() {
        return category;
    }

    public CreateEmployeeDTO getEmployee() {
        return employee;
    }

    public CreateDivisionDTO getDivision() {
        return division;
    }

    public CreateAddressDTO getAddress() {
        return address;
    }

}
