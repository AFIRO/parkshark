package com.switchfully.parkshark.service;

import com.switchfully.parkshark.dto.allocation.AllocationDTO;
import com.switchfully.parkshark.dto.allocation.CreateAllocationDTO;
import com.switchfully.parkshark.entity.Allocation;
import com.switchfully.parkshark.entity.Member;
import com.switchfully.parkshark.exceptions.allocation.AllocationAlreadyStoppedException;
import com.switchfully.parkshark.exceptions.allocation.NoSuchAllocationException;
import com.switchfully.parkshark.exceptions.allocation.WrongOwnerOfAllocationException;
import com.switchfully.parkshark.exceptions.allocation.WrongOwnerOfLicensePlateException;
import com.switchfully.parkshark.mapper.AllocationMapper;
import com.switchfully.parkshark.repository.AllocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@Transactional
public class AllocationService {
    private final AllocationRepository allocationRepository;
    private final AllocationMapper allocationMapper;

    public AllocationService(AllocationRepository allocationRepository, AllocationMapper allocationMapper) {
        this.allocationRepository = allocationRepository;
        this.allocationMapper = allocationMapper;
    }

    public List<AllocationDTO> getAllAllocations(Allocation.AllocationStatus filterAllocationStatus, Integer maxResults, Allocation.AllocationSorter sort) {
        // Filter by Status
        Predicate<Allocation> filterStatusPredicate = filterAllocationStatus != null ? allocation -> allocation.getStatus() == filterAllocationStatus : allocation -> true;

        // Maximum Results
        if (maxResults == null) maxResults = Integer.MAX_VALUE;

        // Sort by Start Hour
        Comparator<Allocation> sortComparator = Comparator.comparing(Allocation::getStartHour);
        if (sort == Allocation.AllocationSorter.DESCENDING) sortComparator = sortComparator.reversed();

        return allocationRepository.findAll().stream()
                .filter(filterStatusPredicate)
                .limit(maxResults)
                .sorted(sortComparator)
                .map(allocationMapper::toDto)
                .collect(Collectors.toList());
    }

    public AllocationDTO startAllocation(CreateAllocationDTO createAllocationDTO) {
        Allocation allocation = allocationMapper.toEntity(createAllocationDTO);

        Member member = allocation.getMember();
        if (member.getMembershipLevel() != Member.MembershipLevel.GOLD && !member.getLicensePlate().getLicensePlateNumber().equalsIgnoreCase(createAllocationDTO.getLicensePlate()))
            throw new WrongOwnerOfLicensePlateException();

        allocationRepository.save(allocation);
        return allocationMapper.toDto(allocation);
    }

    public AllocationDTO stopAllocation(int allocationId, int memberId) {
        Allocation allocation = allocationRepository.findAllocationByAllocationId(allocationId);

        if (allocation == null) throw new NoSuchAllocationException();
        if (allocation.getStatus() == Allocation.AllocationStatus.STOPPED)
            throw new AllocationAlreadyStoppedException();
        if (allocation.getMember().getMemberId() != memberId) throw new WrongOwnerOfAllocationException();

        allocation.stop();

        return allocationMapper.toDto(allocation);
    }
}
