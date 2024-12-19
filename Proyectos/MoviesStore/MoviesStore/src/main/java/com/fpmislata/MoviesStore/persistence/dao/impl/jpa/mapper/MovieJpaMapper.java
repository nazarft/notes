package com.fpmislata.MoviesStore.persistence.dao.impl.jpa.mapper;

import com.fpmislata.MoviesStore.domain.model.Movie;
import com.fpmislata.MoviesStore.persistence.dao.impl.jpa.entity.MovieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DirectorJpaMapper.class, ContentRatingJpaMapper.class, GenreJpaMapper.class, ActorJpaMapper.class}  )
public interface MovieJpaMapper {
    MovieJpaMapper INSTANCE = Mappers.getMapper(MovieJpaMapper.class);

    Movie toMovieWithDetails(MovieEntity movieEntity);

    @Mapping(target = "director", ignore = true )
    @Mapping(target = "contentRating", ignore = true )
    @Mapping(target = "genres", ignore = true )
    @Mapping(target = "actors", ignore = true )
    Movie toMovie(MovieEntity movieEntity);

    MovieEntity toMovieEntity(Movie movie);
}
