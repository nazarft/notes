package com.fpmislata.MoviesStore.domain.repository;

import com.fpmislata.MoviesStore.domain.model.ContentRating;

import java.util.Optional;

public interface ContentRatingRepository {
    Optional<ContentRating> findById(Long id);
}
