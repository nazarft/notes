package com.fpmislata.MoviesStore.domain.service;

import com.fpmislata.MoviesStore.domain.model.Director;

import java.util.Optional;

public interface DirectorService {
    Optional<Director> findById(Long id);
}
