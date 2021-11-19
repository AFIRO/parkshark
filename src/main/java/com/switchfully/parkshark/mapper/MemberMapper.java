package com.switchfully.parkshark.mapper;

import com.switchfully.parkshark.dto.member.CreateMemberDTO;
import com.switchfully.parkshark.dto.member.MemberDTO;
import com.switchfully.parkshark.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    private final AddressMapper addressMapper;
    private final LicensePlateMapper licensePlateMapper;

    @Autowired
    public MemberMapper(AddressMapper addressMapper, LicensePlateMapper licensePlateMapper) {
        this.addressMapper = addressMapper;
        this.licensePlateMapper = licensePlateMapper;
    }

    public Member toEntity(CreateMemberDTO createMemberDTO) {
        if (createMemberDTO.getMembershipLevel() == null) {
            return new Member.Builder()
                    .withFirstName(createMemberDTO.getFirstName())
                    .withLastName(createMemberDTO.getLastName())
                    .withAddress(addressMapper.toEntity(createMemberDTO.getAddress()))
                    .withEmail(createMemberDTO.getEmail())
                    .withLicensePlate(licensePlateMapper.toEntity(createMemberDTO.getLicensePlateDTO()))
                    .withTelephoneNumber(createMemberDTO.getTelephoneNumber())
                    .withMembershipLevel(Member.MembershipLevel.BRONZE)
                    .withRegistrationDate(createMemberDTO.getRegistrationDate())
                    .build();
        }
        return new Member.Builder()
                .withFirstName(createMemberDTO.getFirstName())
                .withLastName(createMemberDTO.getLastName())
                .withAddress(addressMapper.toEntity(createMemberDTO.getAddress()))
                .withEmail(createMemberDTO.getEmail())
                .withLicensePlate(licensePlateMapper.toEntity(createMemberDTO.getLicensePlateDTO()))
                .withTelephoneNumber(createMemberDTO.getTelephoneNumber())
                .withMembershipLevel(createMemberDTO.getMembershipLevel())
                .withRegistrationDate(createMemberDTO.getRegistrationDate())
                .build();
    }

    public MemberDTO toDto(Member member) {
        return new MemberDTO.Builder()
                .withFirstName(member.getFirstName())
                .withLastName(member.getLastName())
                .withId(member.getMemberId())
                .withEmail(member.getEmail())
                .withlicensePlateNumber(member.getLicensePlate().getLicensePlateNumber())
                .withTelephoneNumber(member.getTelephoneNumber())
                .withRegistrationDate(member.getRegistrationDate().toString())
                .build();
    }
}
