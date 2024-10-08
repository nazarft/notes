package com.fpmislata.MoviesStore.domain.service;

import com.fpmislata.MoviesStore.domain.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAll();
    Movie getByCode(String code);
}
