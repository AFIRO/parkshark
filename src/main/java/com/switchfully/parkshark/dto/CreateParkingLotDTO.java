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


    public static final class CreateParkingLotDTOBuilder {
        private String name;
        private int maxCapacity;
        private double hourlyPrice;
        private CreateCategoryDTO category;
        private CreateAddressDTO address;
        private CreateEmployeeDTO employee;
        private CreateDivisionDTO division;

        private CreateParkingLotDTOBuilder() {
        }

        public static CreateParkingLotDTOBuilder aCreateParkingLotDTO() {
            return new CreateParkingLotDTOBuilder();
        }

        public CreateParkingLotDTOBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CreateParkingLotDTOBuilder withMaxCapacity(int maxCapacity) {
            this.maxCapacity = maxCapacity;
            return this;
        }

        public CreateParkingLotDTOBuilder withHourlyPrice(double hourlyPrice) {
            this.hourlyPrice = hourlyPrice;
            return this;
        }

        public CreateParkingLotDTOBuilder withCategory(CreateCategoryDTO category) {
            this.category = category;
            return this;
        }

        public CreateParkingLotDTOBuilder withAddress(CreateAddressDTO address) {
            this.address = address;
            return this;
        }

        public CreateParkingLotDTOBuilder withEmployee(CreateEmployeeDTO employee) {
            this.employee = employee;
            return this;
        }

        public CreateParkingLotDTOBuilder withDivision(CreateDivisionDTO division) {
            this.division = division;
            return this;
        }

        public CreateParkingLotDTO build() {
            return new CreateParkingLotDTO(name, maxCapacity, hourlyPrice, category, address, employee, division);
        }
    }
}
