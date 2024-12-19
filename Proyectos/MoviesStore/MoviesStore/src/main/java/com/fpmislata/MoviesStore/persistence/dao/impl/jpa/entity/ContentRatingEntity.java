package com.fpmislata.MoviesStore.persistence.dao.impl.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "content_ratings")
public class ContentRatingEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String rating;
    private String description;
    @Column(name = "is_violent")
    private int isViolent;
    @Column(name = "is_adult")
    private int isAdult;

}
