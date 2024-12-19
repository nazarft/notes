package com.fpmislata.MoviesStore.persistence.dao.impl.jpa.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "movies")
public class MovieEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String code;
    @Column(name = "title_es")
    private String titleEs;
    @Column(name = "title_en")
    private String titleEn;
    @Column(name = "synopsis_en")
    private String synopsisEn;
    @Column(name = "synopsis_es")
    private String synopsisEs;
    private String image;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_rating_id")
    private ContentRatingEntity contentRating;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id")
    private DirectorEntity director;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "movies_actors",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<ActorEntity> actors;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "movies_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<GenreEntity> genres;

}
