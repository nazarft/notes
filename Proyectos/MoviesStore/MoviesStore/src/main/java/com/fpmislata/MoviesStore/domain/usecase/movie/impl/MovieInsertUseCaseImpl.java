package com.fpmislata.MoviesStore.domain.usecase.movie.impl;

import com.fpmislata.MoviesStore.common.annotation.DomainTransactional;
import com.fpmislata.MoviesStore.common.annotation.DomainUseCase;
import com.fpmislata.MoviesStore.domain.model.Movie;
import com.fpmislata.MoviesStore.domain.service.*;
import com.fpmislata.MoviesStore.domain.usecase.movie.MovieInsertUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class MovieInsertUseCaseImpl implements MovieInsertUseCase {
    private final MovieService movieService;
    private final ActorService actorService;
    private final GenreService genreService;
    private final ContentRatingService contentRatingService;
    private final DirectorService directorService;

    @Override
    public void execute(Movie movie) {
        if(movieService.findByCode(movie.getCode()).isPresent()) {
            throw new RuntimeException("Movie with CODE: " + movie.getCode() + " already exists");
        }
        movie.setDirector(directorService.findById(movie.getDirector()
                .getId())
                .orElseThrow(() -> new RuntimeException("Director not found")));
        movie.setContentRating(contentRatingService.findById(movie.getContentRating()
                .getId())
                .orElseThrow(() -> new RuntimeException("Content Rating not found")));
        movie.setActors(actorService.findAllById(movie.getActors()));
        movie.setGenres(genreService.findAllById(movie.getGenres()));
        movieService.save(movie);
    }
}
