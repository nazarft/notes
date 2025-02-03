package io.nazar.songs_project.persistence.dao.impl.jpa.repository;

import io.nazar.songs_project.persistence.dao.impl.jpa.entity.SingerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingerJpaRepository extends JpaRepository<SingerEntity, Long> {

}
