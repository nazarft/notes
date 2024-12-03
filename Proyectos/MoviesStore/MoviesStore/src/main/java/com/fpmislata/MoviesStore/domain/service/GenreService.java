package com.fpmislata.MoviesStore.domain.service;

import com.fpmislata.MoviesStore.domain.model.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getByMovieId(Long idMovie);
    List<Genre> findAllById(List<Genre> genres);
}
