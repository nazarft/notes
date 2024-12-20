package com.fpmislata.MoviesStore.persistence.dao.impl.jpa.repository;

import com.fpmislata.MoviesStore.domain.model.Movie;
import com.fpmislata.MoviesStore.persistence.dao.impl.jpa.entity.MovieEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MovieJpaRepository extends JpaRepository<MovieEntity,Long> {

    @EntityGraph(attributePaths = {"director", "contentRating"})
    Optional<MovieEntity> findByCode(String code);
    @Override
    @Query(value = """
            SELECT * FROM movies m
            JOIN director d ON m.director_id = d.id
            JOIN ContentRatings ON ContentRatings.id = m.content_rating_id
            WHERE m.id = :id
           """, nativeQuery = true)
    Optional<MovieEntity> findById(Long id);

}
