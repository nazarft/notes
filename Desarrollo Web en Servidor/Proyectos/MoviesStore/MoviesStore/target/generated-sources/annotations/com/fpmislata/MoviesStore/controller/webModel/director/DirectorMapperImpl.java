package com.fpmislata.MoviesStore.controller.webModel.director;

import com.fpmislata.MoviesStore.domain.model.Director;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-08T17:23:17+0200",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
public class DirectorMapperImpl implements DirectorMapper {

    @Override
    public DirectorCollection toDirectorCollection(Director director) {
        if ( director == null ) {
            return null;
        }

        long id = 0L;
        String name = null;

        id = director.getId();
        name = director.getName();

        DirectorCollection directorCollection = new DirectorCollection( id, name );

        return directorCollection;
    }
}
