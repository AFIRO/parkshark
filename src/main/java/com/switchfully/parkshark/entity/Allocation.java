package com.switchfully.parkshark.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "allocation")
public class Allocation {

    @Id
    @Column(name = "all_id")
    @SequenceGenerator(name = "allocation_all_id_seq", sequenceName = "allocation_all_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "allocation_all_id_seq")
    private int allocationId;
    @OneToOne
    @JoinColumn(name = "all_mem_id")
    private Member member;
    @OneToOne
    @JoinColumn(name = "all_pl_id")
    private ParkingLot parkingLot;
    @Column(name = "all_start_hour")
    private LocalDateTime startHour;
    @Column(name = "all_end_hour")
    private LocalDateTime endHour;
    @Column(name = "all_status")
    @Enumerated(EnumType.STRING)
    private Allocation.AllocationStatus status;

    public Allocation() {
    }

    public Allocation(Member member, ParkingLot parkingLot, LocalDateTime startHour, LocalDateTime endHour, AllocationStatus status) {
        this.member = member;
        this.parkingLot = parkingLot;
        this.startHour = startHour;
        this.endHour = endHour;
        this.status = status;
    }

    public int getAllocationId() {
        return allocationId;
    }

    public Member getMember() {
        return member;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public LocalDateTime getStartHour() {
        return startHour;
    }

    public LocalDateTime getEndHour() {
        return endHour;
    }

    public AllocationStatus getStatus() {
        return status;
    }

    public void stop() {
        status = AllocationStatus.STOPPED;
        endHour = LocalDateTime.now();
    }

    public enum AllocationStatus {ACTIVE, STOPPED}

    public enum AllocationSorter {ASCENDING, DESCENDING}

    public static final class Builder {
        Member member;
        ParkingLot parkingLot;
        LocalDateTime startHour;
        LocalDateTime endHour;
        private AllocationStatus status;

        public Builder withMember(Member member) {
            this.member = member;
            return this;
        }

        public Builder withParkingLot(ParkingLot parkingLot) {
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

        public Builder withStatus(AllocationStatus status) {
            this.status = status;
            return this;
        }

        public Allocation build() {
            return new Allocation(member, parkingLot, startHour, endHour, status);
        }
    }
}
