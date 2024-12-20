package com.fpmislata.MoviesStore.domain.repository;

import com.fpmislata.MoviesStore.domain.model.Movie;
import com.fpmislata.MoviesStore.domain.model.PageWithCount;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {
    PageWithCount<Movie> getAll(Integer page, Integer size);
    Optional<Movie> findByCode(String code);
    int count();
    void save(Movie movie);
    void delete(Long id);
}
