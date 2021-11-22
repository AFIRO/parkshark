package com.switchfully.parkshark.dto.allocation;

import com.switchfully.parkshark.dto.member.MemberDTO;
import com.switchfully.parkshark.dto.parkinglot.ParkingLotDTO;
import com.switchfully.parkshark.entity.Allocation;

import java.time.LocalDateTime;

public class AllocationDTO {

    private final int allocationId;
    private final LocalDateTime startHour;
    private final LocalDateTime endHour;
    private final Allocation.AllocationStatus status;
    private final MemberDTO member;
    private final ParkingLotDTO parkingLot;

    public AllocationDTO(int allocationId, MemberDTO member, ParkingLotDTO parkingLot, LocalDateTime startHour, LocalDateTime endHour, Allocation.AllocationStatus status) {
        this.allocationId = allocationId;
        this.member = member;
        this.parkingLot = parkingLot;
        this.startHour = startHour;
        this.endHour = endHour;
        this.status = status;
    }

    public int getAllocationId() {
        return allocationId;
    }

    public LocalDateTime getStartHour() {
        return startHour;
    }

    public LocalDateTime getEndHour() {
        return endHour;
    }

    public Allocation.AllocationStatus getStatus() {
        return status;
    }

    public MemberDTO getMember() {
        return member;
    }

    public ParkingLotDTO getParkingLot() {
        return parkingLot;
    }

    public static final class Builder {
        private int allocationId;
        private MemberDTO member;
        private ParkingLotDTO parkingLot;
        private LocalDateTime startHour;
        private LocalDateTime endHour;
        private Allocation.AllocationStatus status;

        public Builder withAllocationId(int allocationId) {
            this.allocationId = allocationId;
            return this;
        }

        public Builder withMember(MemberDTO member) {
            this.member = member;
            return this;
        }

        public Builder withParkingLot(ParkingLotDTO parkingLot) {
            this.parkingLot = parkingLot;
            return this;
        }

        public Builder withStartHour(LocalDateTime startHour) {
            this.startHour = startHour;
            return this;
        }

        public Builder withEndHour(LocalDateTime endHour) {
            this.endHour = endHour;
            return this;
        }

        public Builder withStatus(Allocation.AllocationStatus status) {
            this.status = status;
            return this;
        }

        public AllocationDTO build() {
            return new AllocationDTO(allocationId, member, parkingLot, startHour, endHour, status);
        }
    }
}
