package com.fpmislata.MoviesStore.persistence.dao;

import com.fpmislata.MoviesStore.domain.model.Actor;
import com.fpmislata.MoviesStore.domain.model.Genre;
import com.fpmislata.MoviesStore.domain.model.Movie;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

public interface MovieDao {
    List<Movie> getAll(int page, int size);
    Optional<Movie> findByCode(String code);
    Optional<Movie> findById(Long id);
    int count();
    void save(Movie movie);
    void update(Movie movie);
    void delete(Long id);
    long insert(Movie movie);
    void insertActors(Long idMovie, List<Actor> actors);
    void deleteActors(Long idMovie);
    void insertGenres(Long idMovie, List<Genre> genres);
    void deleteGenres(Long idMovie);
}