package io.nazar.songs_project.persistence.dao.impl.jpa.repository;

import io.nazar.songs_project.domain.model.Song;
import io.nazar.songs_project.persistence.dao.impl.jpa.entity.SongEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SongJpaRepository extends JpaRepository<SongEntity,Long> {
    @Query("""
            select s from SongEntity s
            join fetch s.editorial e 
            where s.id = :id
            """)
    Optional<SongEntity> findById(Long id);
}
