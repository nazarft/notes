package com.fpmislata.MoviesStore.controller.webModel.director;

import com.fpmislata.MoviesStore.domain.model.Director;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface DirectorMapper {
    DirectorMapper INSTANCE = Mappers.getMapper(DirectorMapper.class);
    DirectorCollection toDirectorCollection(Director director);
}
