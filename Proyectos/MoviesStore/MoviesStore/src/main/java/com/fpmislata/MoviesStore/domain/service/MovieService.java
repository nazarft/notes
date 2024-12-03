package com.fpmislata.MoviesStore.domain.service;

import com.fpmislata.MoviesStore.domain.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> getAll(int page, int size);
    Optional<Movie> findByCode(String code);
    Optional<Movie> findById(Long id);
    int count();
    void save(Movie movie);
    void delete(Long id);
}