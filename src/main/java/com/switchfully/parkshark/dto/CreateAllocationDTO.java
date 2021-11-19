package com.switchfully.parkshark.dto;

import com.switchfully.parkshark.entity.Allocation;

import java.time.LocalDateTime;

public class CreateAllocationDTO {

    private final int memberId;
    private final int parkingLotId;
    private final String licensePlate;
    private final LocalDateTime startHour;
    private final Allocation.AllocationStatus status;

    public CreateAllocationDTO(int memberId, int parkingLotId, String licensePlate, LocalDateTime startHour, Allocation.AllocationStatus status) {
        this.memberId = memberId;
        this.parkingLotId = parkingLotId;
        this.licensePlate = licensePlate;
        this.startHour = startHour;
        this.status = status;
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

    public LocalDateTime getStartHour() {
        return startHour;
    }

    public Allocation.AllocationStatus getStatus() {
        return status;
    }
}
