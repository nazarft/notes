package com.fpmislata.MoviesStore.domain.usecase.movie.impl;

import com.fpmislata.MoviesStore.common.annotation.DomainTransactional;
import com.fpmislata.MoviesStore.common.annotation.DomainUseCase;
import com.fpmislata.MoviesStore.common.exception.ResourceNotFoundException;
import com.fpmislata.MoviesStore.domain.model.Movie;
import com.fpmislata.MoviesStore.domain.service.MovieService;
import com.fpmislata.MoviesStore.domain.usecase.movie.MovieFindByCodeUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class MovieFindByCodeUseCaseImpl implements MovieFindByCodeUseCase {
    private final MovieService movieService;

    @Override
    public Movie execute(String code) {
        return movieService.findByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Movie with CODE: " + code + "NOT FOUND"));
    }
}
