package com.fpmislata.MoviesStore.persistence.dao.impl.jpa.repository;

import com.fpmislata.MoviesStore.persistence.dao.impl.jpa.entity.ContentRatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRatingJpaRepository extends JpaRepository<ContentRatingEntity, Long> {
}
