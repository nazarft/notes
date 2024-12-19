package com.fpmislata.MoviesStore.persistence.dao.impl.jpa.mapper;

import com.fpmislata.MoviesStore.domain.model.Director;
import com.fpmislata.MoviesStore.persistence.dao.impl.jpa.entity.DirectorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DirectorJpaMapper {
    DirectorJpaMapper INSTANCE = Mappers.getMapper(DirectorJpaMapper.class);
    Director toDirector(DirectorEntity directorEntity);
    DirectorEntity toDirectorEntity(Director director);
}
