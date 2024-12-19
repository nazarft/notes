package com.fpmislata.MoviesStore.persistence.dao.impl.jpa.mapper;

import com.fpmislata.MoviesStore.domain.model.Genre;
import com.fpmislata.MoviesStore.persistence.dao.impl.jpa.entity.GenreEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GenreJpaMapper {
    GenreJpaMapper INSTANCE = Mappers.getMapper(GenreJpaMapper.class);
    Genre toGenre(GenreEntity genreEntity);
    GenreEntity toGenreEntity(Genre genre);
}
