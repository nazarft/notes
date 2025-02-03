package io.nazar.songs_project.persistence.dao;

import io.nazar.songs_project.domain.model.Editorial;

import java.util.Optional;

public interface EditorialDao {
    Optional<Editorial> findById(Long id);
}
