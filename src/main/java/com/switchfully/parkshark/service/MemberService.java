package com.switchfully.parkshark.service;

import com.switchfully.parkshark.dto.member.CreateMemberDTO;
import com.switchfully.parkshark.dto.member.MemberDTO;
import com.switchfully.parkshark.entity.Member;
import com.switchfully.parkshark.exceptions.member.NoSuchMemberException;
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
    private final ValidationService validation;
    private final Logger logger = LoggerFactory.getLogger(MemberService.class);

    @Autowired
    public MemberService(MemberMapper mapper, MemberRepository repository, ValidationService validation) {
        this.mapper = mapper;
        this.repository = repository;
        this.validation = validation;
    }

    public MemberDTO createMember(CreateMemberDTO createMemberDTO) {
        validation.assertCorrectCreateMemberDTO(createMemberDTO);
        logger.info("Data for create member valid");
        var newMember = mapper.toEntity(createMemberDTO);
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


}
