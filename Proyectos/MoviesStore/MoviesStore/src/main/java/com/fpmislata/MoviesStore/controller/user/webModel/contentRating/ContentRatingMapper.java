package com.fpmislata.MoviesStore.controller.user.webModel.contentRating;

import com.fpmislata.MoviesStore.domain.model.ContentRating;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ContentRatingMapper {
    ContentRatingMapper INSTANCE = Mappers.getMapper(ContentRatingMapper.class);
    ContentRatingCollectionResponse toContentRatingCollection(ContentRating contentRating);
}
