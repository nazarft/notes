package com.fpmislata.MoviesStore.domain.repository;

import com.fpmislata.MoviesStore.domain.model.Director;

import java.util.Optional;

public interface DirectorRepository {
    Optional<Director> findById(Long id);
}
