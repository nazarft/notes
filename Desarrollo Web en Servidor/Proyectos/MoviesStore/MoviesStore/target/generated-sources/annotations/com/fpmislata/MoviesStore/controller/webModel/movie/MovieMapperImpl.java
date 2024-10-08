package com.fpmislata.MoviesStore.controller.webModel.movie;

import com.fpmislata.MoviesStore.controller.webModel.actor.ActorCollection;
import com.fpmislata.MoviesStore.controller.webModel.actor.ActorMapper;
import com.fpmislata.MoviesStore.controller.webModel.director.DirectorCollection;
import com.fpmislata.MoviesStore.controller.webModel.director.DirectorMapper;
import com.fpmislata.MoviesStore.controller.webModel.genre.GenreMapper;
import com.fpmislata.MoviesStore.domain.model.Actor;
import com.fpmislata.MoviesStore.domain.model.ContentRating;
import com.fpmislata.MoviesStore.domain.model.Movie;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-08T17:52:31+0200",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
public class MovieMapperImpl implements MovieMapper {

    private final ActorMapper actorMapper = ActorMapper.INSTANCE;
    private final GenreMapper genreMapper = GenreMapper.INSTANCE;
    private final DirectorMapper directorMapper = DirectorMapper.INSTANCE;

    @Override
    public MovieCollection toMovieCollection(Movie movie) {
        if ( movie == null ) {
            return null;
        }

        String code = null;
        String title_es = null;
        String image = null;

        code = movie.getCode();
        title_es = movie.getTitle_es();
        image = movie.getImage();

        MovieCollection movieCollection = new MovieCollection( code, title_es, image );

        return movieCollection;
    }

    @Override
    public MovieDetail toMovieDetail(Movie movie) {
        if ( movie == null ) {
            return null;
        }

        DirectorCollection directorCollection = null;
        List<ActorCollection> actorCollection = null;
        String contentRating = null;
        List<String> genres = null;
        String code = null;
        String title_es = null;
        String image = null;
        String synopsis_es = null;

        directorCollection = directorMapper.toDirectorCollection( movie.getDirector() );
        actorCollection = actorListToActorCollectionList( movie.getActors() );
        contentRating = movieContentRatingRating( movie );
        genres = genreMapper.toGenreNameList( movie.getGenres() );
        code = movie.getCode();
        title_es = movie.getTitle_es();
        image = movie.getImage();
        synopsis_es = movie.getSynopsis_es();

        MovieDetail movieDetail = new MovieDetail( code, title_es, image, genres, synopsis_es, contentRating, actorCollection, directorCollection );

        return movieDetail;
    }

    protected List<ActorCollection> actorListToActorCollectionList(List<Actor> list) {
        if ( list == null ) {
            return null;
        }

        List<ActorCollection> list1 = new ArrayList<ActorCollection>( list.size() );
        for ( Actor actor : list ) {
            list1.add( actorMapper.toActorCollection( actor ) );
        }

        return list1;
    }

    private String movieContentRatingRating(Movie movie) {
        ContentRating contentRating = movie.getContentRating();
        if ( contentRating == null ) {
            return null;
        }
        return contentRating.getRating();
    }
}
