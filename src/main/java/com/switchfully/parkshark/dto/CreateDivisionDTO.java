package com.switchfully.parkshark.dto;

import com.switchfully.parkshark.entity.Division;
import com.switchfully.parkshark.entity.Employee;

public class CreateDivisionDTO {

    private final String name;
    private final String originalName;
    private final Integer director;
    private final Integer division;

    public CreateDivisionDTO(String name, String originalName, Integer director, Integer division) {
        this.name = name;
        this.originalName = originalName;
        this.director = director;
        this.division = division;
    }

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public Integer getDirector() {
        return director;
    }

    public Integer getDivision() {
        return division;
    }
}
