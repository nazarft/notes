package com.fpmislata.MoviesStore.persistence.dao.impl.jpa;

import com.fpmislata.MoviesStore.domain.model.ContentRating;
import com.fpmislata.MoviesStore.persistence.dao.ContentRatingDao;
import com.fpmislata.MoviesStore.persistence.dao.impl.jpa.mapper.ContentRatingJpaMapper;
import com.fpmislata.MoviesStore.persistence.dao.impl.jpa.repository.ContentRatingJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Component
@RequiredArgsConstructor
@Primary
public class ContentRatingJpa implements ContentRatingDao {
    private final ContentRatingJpaRepository contentRatingJpaRepository;

    @Override
    public Optional<ContentRating> findById(Long id) {
        return contentRatingJpaRepository.findById(id)
                .map(contentRating -> ContentRatingJpaMapper.INSTANCE.toContentRating(contentRating));
    }

    @Override
    public List<ContentRating> getAll() {
        return List.of();
    }

    @Override
    public List<ContentRating> getAll(int page, int size) {
        return List.of();
    }
    @Override
    public long insert(ContentRating contentRating) {
        return 0;
    }

    @Override
    public void update(ContentRating contentRating) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void save(ContentRating contentRating) {

    }
}
