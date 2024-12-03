package com.fpmislata.MoviesStore.persistence.impl;

import com.fpmislata.MoviesStore.domain.model.ContentRating;
import com.fpmislata.MoviesStore.domain.repository.ContentRatingRepository;
import com.fpmislata.MoviesStore.persistence.dao.ContentRatingDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@RequiredArgsConstructor
public class ContentRatingRepositoryJdbc implements ContentRatingRepository {
    private final ContentRatingDao contentRatingDao;
    @Override
    public Optional<ContentRating> findById(Long id) {
        return contentRatingDao.findById(id);
    }
}
