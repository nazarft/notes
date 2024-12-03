package com.fpmislata.MoviesStore.persistence.dao;

import com.fpmislata.MoviesStore.domain.model.Genre;

import java.util.List;

public interface GenreDao {
    List<Genre> getByMovieId(Long idMovie);
    List<Genre> findAllById(Long[] ids);
}