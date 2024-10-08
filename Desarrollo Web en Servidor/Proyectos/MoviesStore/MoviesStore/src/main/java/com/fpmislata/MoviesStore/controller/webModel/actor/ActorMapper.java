package com.fpmislata.MoviesStore.controller.webModel.actor;

import com.fpmislata.MoviesStore.domain.model.Actor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActorMapper {
    ActorMapper INSTANCE = Mappers.getMapper(ActorMapper.class);
    ActorCollection toActorCollection(Actor actor);
}
