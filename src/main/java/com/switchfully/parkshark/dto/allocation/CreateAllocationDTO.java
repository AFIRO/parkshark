package com.switchfully.parkshark.dto.allocation;

public class CreateAllocationDTO {

    private final int memberId;
    private final int parkingLotId;
    private final String licensePlate;

    public CreateAllocationDTO(int memberId, int parkingLotId, String licensePlate) {
        this.memberId = memberId;
        this.parkingLotId = parkingLotId;
        this.licensePlate = licensePlate;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getParkingLotId() {
        return parkingLotId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}
