package com.fpmislata.MoviesStore.persistence.dao.impl.jpa.mapper;

import com.fpmislata.MoviesStore.domain.model.Actor;
import com.fpmislata.MoviesStore.persistence.dao.impl.jpa.entity.ActorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActorJpaMapper{
    ActorJpaMapper INSTANCE = Mappers.getMapper(ActorJpaMapper.class);
    Actor toActor(ActorEntity actorEntity);
    ActorEntity toActorEntity(Actor actor);
}
