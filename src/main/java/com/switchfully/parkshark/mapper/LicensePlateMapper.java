package com.switchfully.parkshark.mapper;

import com.switchfully.parkshark.dto.licenseplate.CreateLicensePlateDTO;
import com.switchfully.parkshark.entity.LicensePlate;
import org.springframework.stereotype.Component;

@Component
public class LicensePlateMapper {

    public LicensePlate toEntity(CreateLicensePlateDTO dto){
        return new LicensePlate.Builder()
                .withLicensePlateNumber(dto.getLicensePlateNumber())
                .withLicensePlateCountry(dto.getLicensePlateCountry())
                .build();

    }

}
