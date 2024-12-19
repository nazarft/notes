package com.fpmislata.MoviesStore.persistence.dao.impl.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "director")
public class DirectorEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String nationality;
    @Column(name = "biography_en")
    private String biographyEn;
    @Column(name = "biography_es")
    private String biographyEs;
    @Column(name = "birth_year")
    private int birthYear;
    @Column(name = "death_year")
    private Integer deathYear;
}
