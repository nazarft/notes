package com.fpmislata.MoviesStore.controller.user.webModel.movie;

import com.fpmislata.MoviesStore.controller.user.webModel.actor.ActorMapper;
import com.fpmislata.MoviesStore.controller.user.webModel.contentRating.ContentRatingMapper;
import com.fpmislata.MoviesStore.controller.user.webModel.genre.GenreMapper;
import com.fpmislata.MoviesStore.domain.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { ActorMapper.class, ContentRatingMapper.class, GenreMapper.class})
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);
    MovieCollectionResponse toMovieCollection(Movie movie);

    @Mapping(target="director", source = "director.name")
    MovieResponse toMovieDetail(Movie movie);
}
