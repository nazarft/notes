package com.fpmislata.MoviesStore.controller.webModel.actor;

import com.fpmislata.MoviesStore.domain.model.Actor;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-08T17:52:32+0200",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
public class ActorMapperImpl implements ActorMapper {

    @Override
    public ActorCollection toActorCollection(Actor actor) {
        if ( actor == null ) {
            return null;
        }

        long id = 0L;
        String name = null;

        id = actor.getId();
        name = actor.getName();

        ActorCollection actorCollection = new ActorCollection( id, name );

        return actorCollection;
    }
}
