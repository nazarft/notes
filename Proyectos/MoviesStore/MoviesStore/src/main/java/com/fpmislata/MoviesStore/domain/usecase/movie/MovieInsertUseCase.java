package com.fpmislata.MoviesStore.domain.usecase.movie;

import com.fpmislata.MoviesStore.domain.model.Movie;

public interface MovieInsertUseCase {
    void execute(Movie movie);
}
