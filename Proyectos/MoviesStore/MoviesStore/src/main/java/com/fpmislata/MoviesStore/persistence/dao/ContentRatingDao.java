package com.fpmislata.MoviesStore.persistence.dao;

import com.fpmislata.MoviesStore.domain.model.ContentRating;

import java.util.Optional;

public interface ContentRatingDao extends GenericDao<ContentRating> {
    Optional<ContentRating> findById(Long id);
}
