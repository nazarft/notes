package com.fpmislata.MoviesStore.persistence.dao.impl.jpa.repository;

import com.fpmislata.MoviesStore.persistence.dao.impl.jpa.entity.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorJpaRepository extends JpaRepository<ActorEntity, Long> {
    @Query(value = """
            SELECT a.* FROM actors a
            JOIN movies_actors ma ON a.id = ma.actor_id
            JOIN movies m ON m.id = ma.movie_id
            WHERE m.code = :code
            """, nativeQuery = true)
    List<ActorEntity> findByMoviesCode(String code);
    @Query(value = """
            SELECT a.* FROM actors a
            JOIN movies_actors ma ON a.id = ma.actor_id
            WHERE ma.movie_id = :id
            """, nativeQuery = true)
    List<ActorEntity> findByMoviesId(Long id);
}
