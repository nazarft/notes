package com.fpmislata.MoviesStore.persistence.dao.impl.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "actors")
@Data
@NoArgsConstructor
public class ActorEntity {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nationality;
    @Column(name = "biography_en")
    private String biographyEn;
    @Column(name = "biography_es")
    private String biographyEs;
}
