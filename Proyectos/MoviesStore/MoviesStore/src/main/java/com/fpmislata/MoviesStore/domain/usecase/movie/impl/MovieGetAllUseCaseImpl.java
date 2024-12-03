package com.fpmislata.MoviesStore.domain.usecase.movie.impl;

import com.fpmislata.MoviesStore.common.annotation.DomainTransactional;
import com.fpmislata.MoviesStore.common.annotation.DomainUseCase;
import com.fpmislata.MoviesStore.domain.model.Movie;
import com.fpmislata.MoviesStore.domain.service.MovieService;
import com.fpmislata.MoviesStore.domain.usecase.movie.MovieGetAllUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;
@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class MovieGetAllUseCaseImpl implements MovieGetAllUseCase {
    private final MovieService movieService;
    @Override
    public List<Movie> execute(Integer page, Integer size) {
        return movieService.getAll(page, size);
    }
}
