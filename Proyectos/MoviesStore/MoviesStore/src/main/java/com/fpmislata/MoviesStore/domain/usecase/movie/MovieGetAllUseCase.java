package com.fpmislata.MoviesStore.domain.usecase.movie;

import com.fpmislata.MoviesStore.domain.model.Movie;
import com.fpmislata.MoviesStore.domain.model.PageWithCount;

import java.util.List;

public interface MovieGetAllUseCase {
    PageWithCount<Movie> execute(Integer page, Integer size);
}
