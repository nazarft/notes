package com.fpmislata.MoviesStore.domain.repository;

import com.fpmislata.MoviesStore.domain.model.Genre;

import java.util.List;

public interface GenreRepository {
    List<Genre> getByMovieId(Long idMovie);
    List<Genre> findAllById(Long[] ids);
}
