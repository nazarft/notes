package com.fpmislata.MoviesStore.persistence.dao.impl.jpa.repository;

import com.fpmislata.MoviesStore.persistence.dao.impl.jpa.entity.ActorEntity;
import com.fpmislata.MoviesStore.persistence.dao.impl.jpa.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenreJpaRepository extends JpaRepository<GenreEntity, Long> {
    @Query(value = """
            SELECT * FROM genres g
            JOIN movies_genres mg ON g.id = mg.genre_id
            JOIN movies m ON m.id = mg.movie_id
            WHERE m.code = :code
            """, nativeQuery = true)
    List<GenreEntity> findByMoviesCode(String code);
    @Query(value = """
            SELECT * FROM genres g
            JOIN movies_genres mg ON g.id = mg.genre_id
            WHERE mg.movie_id = :id
            """, nativeQuery = true)
    List<GenreEntity> findByMoviesId(Long id);
}
