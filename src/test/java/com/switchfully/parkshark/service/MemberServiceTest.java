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
    private CreateMemberDTO createMemberDTO;
    private MemberDTO newMemberDTO;
    private ValidationService validation;

    @BeforeEach
    void before() {
        memberRepository = Mockito.mock(MemberRepository.class);
        memberService = new MemberService(memberMapper, memberRepository, validation);
        CreateAddressDTO newAddressDTO = new CreateAddressDTO("testStreet", "1", "2000", "Brussels");
        CreateLicensePlateDTO newLicensePlateDTO = new CreateLicensePlateDTO("1", "1");
        createMemberDTO = new CreateMemberDTO();
//        createMemberDTO.setFirstName("John");
//        createMemberDTO.setLastName("Doe");
//        createMemberDTO.setAddress(newAddressDTO);
//        createMemberDTO.setLicensePlateDTO(newLicensePlateDTO);
        newMember = memberMapper.toEntity(createMemberDTO);
        newMemberDTO = memberMapper.toDto(newMember);
    }

    @Test
    void givenAMemberService_whenSavingAMember_thenVerifySaveWithRepository() {
        memberService.createMember(createMemberDTO);
        Mockito.verify(memberRepository).save(Mockito.any());
        // Mockito.verify(memberRepository).save(newMember);
    }

    @Test
    void givenAMemberService_whenAskingForAllMembers_thenVerifyGetAllMembersWithRepository() {
        memberService.getAllMembers();
        Mockito.verify(memberRepository).findAll();
    }

    @Test
    void givenAMemberService_whenSavingAMember_thenReturnAsMemberDTO() {
        Mockito.when(memberService.createMember(createMemberDTO)).thenReturn(newMemberDTO);
    }
}