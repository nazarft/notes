package com.fpmislata.MoviesStore.persistence.dao.impl.jpa;

import com.fpmislata.MoviesStore.domain.model.Actor;
import com.fpmislata.MoviesStore.domain.model.Genre;
import com.fpmislata.MoviesStore.domain.model.Movie;
import com.fpmislata.MoviesStore.persistence.dao.MovieDao;
import com.fpmislata.MoviesStore.persistence.dao.impl.jpa.entity.ActorEntity;
import com.fpmislata.MoviesStore.persistence.dao.impl.jpa.entity.MovieEntity;
import com.fpmislata.MoviesStore.persistence.dao.impl.jpa.mapper.ActorJpaMapper;
import com.fpmislata.MoviesStore.persistence.dao.impl.jpa.mapper.MovieJpaMapper;
import com.fpmislata.MoviesStore.persistence.dao.impl.jpa.repository.ActorJpaRepository;
import com.fpmislata.MoviesStore.persistence.dao.impl.jpa.repository.MovieJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
@Primary
@RequiredArgsConstructor
public class MovieDaoJpa implements MovieDao {
    private final MovieJpaRepository movieJpaRepository;
    private final ActorJpaRepository actorJpaRepository;

    @Override
    public Optional<Movie> findByCode(String code) {
            return Optional.ofNullable(movieJpaRepository.findByCode(code))
                    .map(movie -> MovieJpaMapper.INSTANCE.toMovieWithDetails(movie));
    }
    @Override
    public void insertActors(Long idMovie, List<Actor> actors) {
        movieJpaRepository.findById(idMovie)
                .ifPresent(movieEntity -> movieEntity.setActors(
                        actors.stream()
                                .map(actor -> ActorJpaMapper.INSTANCE.toActorEntity(actor))
                                .toList()
                ));

    }
    @Override
    public void deleteActors(Long idMovie) {

    }

    @Override
    public void insertGenres(Long idMovie, List<Genre> genres) {

    }

    @Override
    public void deleteGenres(Long idMovie) {

    }

    @Override
    public List<Movie> getAll() {
        return movieJpaRepository.findAll()
                .stream()
                .map(movie -> MovieJpaMapper.INSTANCE.toMovie(movie))
                .toList();
    }

    @Override
    public List<Movie> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<MovieEntity> movieEntities = movieJpaRepository.findAll(pageable);
        return movieEntities.getContent()
                .stream()
                .map(movie -> MovieJpaMapper.INSTANCE.toMovie(movie))
                .toList();

    }

    @Override
    public Optional<Movie> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public long insert(Movie movie) {
        return 0;
    }

    @Override
    public void update(Movie movie) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void save(Movie movie) {

    }
}
