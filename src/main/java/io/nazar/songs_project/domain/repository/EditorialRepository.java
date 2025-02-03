package io.nazar.songs_project.domain.repository;


import io.nazar.songs_project.domain.model.Editorial;

import java.util.Optional;

public interface EditorialRepository {
    Optional<Editorial> findById(Long id);
}
