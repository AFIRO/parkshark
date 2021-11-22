package com.switchfully.parkshark.mapper;

import com.switchfully.parkshark.dto.allocation.AllocationDTO;
import com.switchfully.parkshark.dto.allocation.CreateAllocationDTO;
import com.switchfully.parkshark.dto.member.MemberDTO;
import com.switchfully.parkshark.dto.parkinglot.ParkingLotDTO;
import com.switchfully.parkshark.entity.Allocation;
import com.switchfully.parkshark.entity.Member;
import com.switchfully.parkshark.entity.ParkingLot;
import com.switchfully.parkshark.exceptions.allocation.ParkingLotIsAlreadyFullException;
import com.switchfully.parkshark.exceptions.allocation.WrongOwnerOfLicensePlateException;
import com.switchfully.parkshark.exceptions.member.NoSuchMemberException;
import com.switchfully.parkshark.exceptions.parkinglot.NoSuchParkingLotException;
import com.switchfully.parkshark.repository.AllocationRepository;
import com.switchfully.parkshark.repository.MemberRepository;
import com.switchfully.parkshark.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AllocationMapper {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;
    private final AllocationRepository allocationRepository;
    private final ParkingLotRepository parkingLotRepository;
    private final ParkingLotMapper parkingLotMapper;

    @Autowired
    public AllocationMapper(MemberRepository memberRepository, MemberMapper memberMapper, AllocationRepository allocationRepository, ParkingLotRepository parkingLotRepository, ParkingLotMapper parkingLotMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
        this.allocationRepository = allocationRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingLotMapper = parkingLotMapper;
    }

    public Allocation toEntity(CreateAllocationDTO createAllocationDTO) {

        Member member = memberRepository.findMemberByMemberId(createAllocationDTO.getMemberId());
        ParkingLot parkingLot = parkingLotRepository.findParkingLotByParkingLotId(createAllocationDTO.getParkingLotId());

        if (member == null) throw new NoSuchMemberException();
        if (parkingLot == null) throw new NoSuchParkingLotException();

        if (member.getMembershipLevel() != Member.MembershipLevel.GOLD && !member.getLicensePlate().getLicensePlateNumber().equalsIgnoreCase(createAllocationDTO.getLicensePlate())) throw new WrongOwnerOfLicensePlateException();

        int activeAllocationsForParkingLot = allocationRepository.countAllocationByParkingLotParkingLotIdAndStatus(parkingLot.getParkingLotId(), Allocation.AllocationStatus.ACTIVE);
        int maximumCapacityOfParkingLot = parkingLot.getMaxCapacity();
        if (activeAllocationsForParkingLot >= maximumCapacityOfParkingLot) throw new ParkingLotIsAlreadyFullException();

        return new Allocation.Builder()
                .withMember(member)
                .withParkingLot(parkingLot)
                .withStartHour(LocalDateTime.now())
                .withStatus(Allocation.AllocationStatus.ACTIVE)
                .build();
    }

    public AllocationDTO toDto(Allocation allocation) {

        MemberDTO memberDTO = memberMapper.toDto(allocation.getMember());
        ParkingLotDTO parkingLotDTO = parkingLotMapper.toDto(allocation.getParkingLot());

        return new AllocationDTO.Builder()
                .withAllocationId(allocation.getAllocationId())
                .withMember(memberDTO)
                .withParkingLot(parkingLotDTO)
                .withStartHour(allocation.getStartHour())
                .withEndHour(allocation.getEndHour())
                .withStatus(allocation.getStatus())
                .build();
    }
}
