package com.switchfully.parkshark.service;

import com.switchfully.parkshark.dto.CreateAddressDTO;
import com.switchfully.parkshark.dto.CreateLicensePlateDTO;
import com.switchfully.parkshark.dto.CreateMemberDTO;
import com.switchfully.parkshark.dto.MemberDTO;
import com.switchfully.parkshark.exceptions.BadCreateAddressException;
import com.switchfully.parkshark.exceptions.BadCreateLicensePlateException;
import com.switchfully.parkshark.exceptions.BadCreateMemberException;
import com.switchfully.parkshark.exceptions.NoSuchMemberException;
import com.switchfully.parkshark.mapper.MemberMapper;
import com.switchfully.parkshark.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MemberService {

    private final MemberMapper mapper;
    private final MemberRepository repository;
    private final Logger logger = LoggerFactory.getLogger(MemberService.class);

    @Autowired
    public MemberService(MemberMapper mapper, MemberRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public MemberDTO createMember(CreateMemberDTO createMemberDTO) {
        assertCorrectCreateMemberDTO(createMemberDTO);
        var newMember = mapper.toEntity(createMemberDTO);
        logger.info("Data for create member valid");
        repository.save(newMember);
        return mapper.toDto(newMember);
    }

    public List<MemberDTO> getAllMembers() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public MemberDTO getSpecificMemberById(int memberId) {
        var returnedMember = repository.findMemberByMemberId(memberId);
        if (returnedMember == null) {
            logger.error("Non-existent member requested");
            throw new NoSuchMemberException();
        }
        return mapper.toDto(repository.findMemberByMemberId(memberId));
    }

    private boolean checkValid(String input) {
        return input != null && !input.isBlank() && !input.isEmpty();
    }

    private boolean assertCorrectCreateMemberDTO(CreateMemberDTO createMemberDTO) {
        var toCheck = checkValid(createMemberDTO.getFirstName()) && checkValid(createMemberDTO.getLastName()) && checkValid(createMemberDTO.getEmail()) && checkValid(createMemberDTO.getLicensePlateDTO().getLicensePlateNumber()) && checkValid(createMemberDTO.getLicensePlateDTO().getLicensePlateCountry()) && checkValid(createMemberDTO.getTelephoneNumber()) && assertCorrectCreateLicensePlateDTO(createMemberDTO.getLicensePlateDTO()) && assertCorrectCreateAddressDTO(createMemberDTO.getAddress());

        if (!toCheck) {
            logger.error("Data provided for new member invalid");
            throw new BadCreateMemberException();
        }

        return true;
    }

    private boolean assertCorrectCreateAddressDTO(CreateAddressDTO dto) {
        var toCheck = checkValid(dto.getZipcode()) && checkValid(dto.getCity()) && checkValid(dto.getStreet()) && checkValid(dto.getHouseNumber());

        if (!toCheck) {
            logger.error("Data provided for new member address invalid");
            throw new BadCreateAddressException();
        }

        return true;
    }

    private boolean assertCorrectCreateLicensePlateDTO(CreateLicensePlateDTO dto) {
        var toCheck = checkValid(dto.getLicensePlateCountry()) && checkValid(dto.getLicensePlateNumber());

        if (!toCheck) {
            logger.error("Data provided for new member address invalid");
            throw new BadCreateLicensePlateException();
        }

        return true;
    }

}
