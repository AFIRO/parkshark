package com.switchfully.parkshark.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Division")
public class Division {

    @Id
    @Column(name = "div_id")
    @SequenceGenerator(name = "Division_div_id_seq", sequenceName = "Division_div_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Division_div_id_seq")
    private int divisionId;

    @Column(name = "div_name")
    private String name;

    @Column(name = "div_original_name")
    private String originalName;

    @OneToOne
    @JoinColumn(name = "div_director_id")
    private Employee director;

    @OneToOne
    @JoinColumn(name = "div_upper_div_id")
    private Division upperDivision;

    public Division(String name, String originalName, Employee director, Division upperDivision) {
        this.name = name;
        this.originalName = originalName;
        this.director = director;
        this.upperDivision = upperDivision;
    }

    public Division() {
    }

    public int getId() {
        return divisionId;
    }

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public Employee getDirector() {
        return director;
    }

    public Division getUpperDivision() {
        return upperDivision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Division division = (Division) o;
        return divisionId == division.divisionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(divisionId);
    }

    public static final class Builder {
        private String name;
        private String originalName;
        private Employee director;
        private Division upperDivision;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withOriginalName(String originalName) {
            this.originalName = originalName;
            return this;
        }

        public Builder withDirector(Employee director) {
            this.director = director;
            return this;
        }

        public Builder withUpperDivision(Division upperDivision) {
            this.upperDivision = upperDivision;
            return this;
        }

        public Division build() {
            return new Division(name, originalName, director, upperDivision);
        }
    }
}
