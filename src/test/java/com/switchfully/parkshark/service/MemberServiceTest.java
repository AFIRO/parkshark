package com.switchfully.parkshark.service;

import com.switchfully.parkshark.dto.CreateAddressDTO;
import com.switchfully.parkshark.dto.CreateLicensePlateDTO;
import com.switchfully.parkshark.dto.CreateMemberDTO;
import com.switchfully.parkshark.dto.MemberDTO;
import com.switchfully.parkshark.entity.Member;
import com.switchfully.parkshark.mapper.MemberMapper;
import com.switchfully.parkshark.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberMapper memberMapper;
    private MemberRepository memberRepository;
    private Member newMember;
    private CreateMemberDTO newMemberDTO;

    @BeforeEach
    void before() {
        memberRepository = Mockito.mock(MemberRepository.class);
        memberService = new MemberService(memberMapper, memberRepository);
        CreateAddressDTO newAddressDTO = new CreateAddressDTO();
        CreateLicensePlateDTO newLicensePlateDTO = new CreateLicensePlateDTO();
        newMemberDTO = new CreateMemberDTO();
        newMemberDTO.setFirstName("John");
        newMemberDTO.setLastName("Doe");
        newMemberDTO.setAddress(newAddressDTO);
        newMemberDTO.setLicensePlateDTO(newLicensePlateDTO);
        newMember = memberMapper.toEntity(newMemberDTO);
    }

    @Test
    void givenAMemberService_whenSavingAMember_thenVerifySaveWithRepository() {
        memberService.createMember(newMemberDTO);
        Mockito.verify(memberRepository).save(Mockito.any());
    }

    @Test
    void givenAMemberService_whenAskingForAllMembers_thenVerifyGetAllMembersWithRepository() {
        memberService.getAllMembers();
        Mockito.verify(memberRepository).findAll();
    }
}