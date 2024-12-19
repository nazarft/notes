package com.fpmislata.MoviesStore.persistence.dao.impl.jpa.mapper;

import com.fpmislata.MoviesStore.persistence.dao.impl.jpa.entity.ContentRatingEntity;
import org.mapstruct.Mapper;
import com.fpmislata.MoviesStore.domain.model.ContentRating;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContentRatingJpaMapper {
    ContentRatingJpaMapper INSTANCE = Mappers.getMapper(ContentRatingJpaMapper.class);
    ContentRating toContentRating(ContentRatingEntity contentRatingEntity);
    ContentRatingEntity toContentRatingEntity(ContentRating contentRating);

}
