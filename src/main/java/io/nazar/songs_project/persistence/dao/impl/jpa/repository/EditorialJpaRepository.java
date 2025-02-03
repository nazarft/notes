package io.nazar.songs_project.persistence.dao.impl.jpa.repository;

import io.nazar.songs_project.domain.model.Editorial;
import io.nazar.songs_project.persistence.dao.impl.jpa.entity.EditorialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditorialJpaRepository extends JpaRepository<EditorialEntity,Long> {
}
