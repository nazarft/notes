package com.fpmislata.MoviesStore.controller.webModel.movie;

import com.fpmislata.MoviesStore.controller.webModel.actor.ActorMapper;
import com.fpmislata.MoviesStore.controller.webModel.director.DirectorMapper;
import com.fpmislata.MoviesStore.controller.webModel.genre.GenreMapper;
import com.fpmislata.MoviesStore.domain.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper(uses = {ActorMapper.class, GenreMapper.class, DirectorMapper.class})
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);
    MovieCollection toMovieCollection(Movie movie);


    @Mapping(target = "directorCollection", source = "director")
    @Mapping(target = "actorCollection",source = "actors")
    @Mapping(target = "contentRating", source = "contentRating.rating")
    @Mapping(target = "genres", source = "genres")

    MovieDetail toMovieDetail(Movie movie);
}
