package com.fpmislata.MoviesStore.domain.service.impl;

import com.fpmislata.MoviesStore.domain.model.ContentRating;
import com.fpmislata.MoviesStore.domain.repository.ContentRatingRepository;
import com.fpmislata.MoviesStore.domain.service.ContentRatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@RequiredArgsConstructor
public class ContentRatingServiceImpl implements ContentRatingService {
    private final ContentRatingRepository contentRatingRepository;
    @Override
    public Optional<ContentRating> findById(Long id) {
        return contentRatingRepository.findById(id);
    }
}
