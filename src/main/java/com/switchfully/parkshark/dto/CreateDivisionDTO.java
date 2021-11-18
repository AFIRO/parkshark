package com.switchfully.parkshark.dto;

public class CreateDivisionDTO {

    private final String name;
    private final String originalName;
    private final Integer director;
    private final Integer upperDivision;

    public CreateDivisionDTO(String name, String originalName, Integer director, Integer division) {
        this.name = name;
        this.originalName = originalName;
        this.director = director;
        this.upperDivision = division;
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

    public Integer getUpperDivision() {
        return upperDivision;
    }
}
