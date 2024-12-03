package com.fpmislata.MoviesStore.controller.admin.webModel.movie;


import com.fpmislata.MoviesStore.domain.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);
    MovieCollectionResponse toMovieCollection(Movie movie);

}
