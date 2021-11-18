package com.switchfully.parkshark.mapper;

import com.switchfully.parkshark.dto.CreateMemberDTO;
import com.switchfully.parkshark.dto.MemberDTO;
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

    public Member toEntity(CreateMemberDTO dto) {
        if (dto.getMembershipLevel() == null) {
            return new Member.Builder()
                    .withFirstName(dto.getFirstName())
                    .withLastName(dto.getLastName())
                    .withAddress(addressMapper.toEntity(dto.getAddress()))
                    .withEmail(dto.getEmail())
                    .withLicensePlate(licensePlateMapper.toEntity(dto.getLicensePlateDTO()))
                    .withTelephoneNumber(dto.getTelephoneNumber())
                    .withMembershipLevel(Member.MembershipLevel.BRONZE)
                    .withRegistrationDate(dto.getRegistrationDate())
                    .build();
        }
        return new Member.Builder()
                .withFirstName(dto.getFirstName())
                .withLastName(dto.getLastName())
                .withAddress(addressMapper.toEntity(dto.getAddress()))
                .withEmail(dto.getEmail())
                .withLicensePlate(licensePlateMapper.toEntity(dto.getLicensePlateDTO()))
                .withTelephoneNumber(dto.getTelephoneNumber())
                .withMembershipLevel(dto.getMembershipLevel())
                .withRegistrationDate(dto.getRegistrationDate())
                .build();
    }

    public MemberDTO toDTO(Member member) {
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
