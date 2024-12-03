package com.fpmislata.MoviesStore.domain.usecase.movie;

import com.fpmislata.MoviesStore.domain.model.Movie;

import java.util.List;

public interface MovieGetAllUseCase {
    List<Movie>execute(Integer page, Integer size);
}
