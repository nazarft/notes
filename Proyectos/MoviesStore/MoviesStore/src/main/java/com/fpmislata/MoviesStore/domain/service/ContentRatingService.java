package com.fpmislata.MoviesStore.domain.service;

import com.fpmislata.MoviesStore.domain.model.ContentRating;

import java.util.Optional;

public interface ContentRatingService {
    Optional<ContentRating> findById(Long id);
}
