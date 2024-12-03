package com.fpmislata.MoviesStore.domain.usecase.movie.impl;

import com.fpmislata.MoviesStore.common.annotation.DomainTransactional;
import com.fpmislata.MoviesStore.common.annotation.DomainUseCase;
import com.fpmislata.MoviesStore.domain.service.MovieService;
import com.fpmislata.MoviesStore.domain.usecase.movie.MovieCountUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class MovieCountUseCaseImpl implements MovieCountUseCase {
    private final MovieService movieService;
    @Override
    public int execute() {
        return movieService.count();
    }
}
