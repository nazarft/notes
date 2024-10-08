package com.fpmislata.MoviesStore.persistence.impl;

import com.fpmislata.MoviesStore.domain.model.Movie;
import com.fpmislata.MoviesStore.domain.repository.ActorRepository;
import com.fpmislata.MoviesStore.domain.repository.GenreRepository;
import com.fpmislata.MoviesStore.domain.repository.MovieRepository;
import com.fpmislata.MoviesStore.persistence.impl.mapper.MovieRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
@RequiredArgsConstructor
public class MovieRepositoryJdbc implements MovieRepository {
    private final JdbcTemplate jdbcTemplate;
    private final ActorRepository actorRepository;
    private final GenreRepository genreRepository;
    @Override
    public List<Movie> getAll() {
        String sql = """
                SELECT * from movies
                LEFT JOIN director on movies.director_id = director.id
                LEFT JOIN ContentRatings on movies.contentRating_id = ContentRatings.id
                """;
        return jdbcTemplate.query(sql, new MovieRowMapper());
    }

    @Override
    public Optional<Movie> findByCode(String code) {
        String sql = """
                SELECT * from movies
                LEFT JOIN director on movies.director_id = director.id
                LEFT JOIN ContentRatings on movies.contentRating_id = ContentRatings.id
                WHERE movies.code = ?
                """;
        try{
            Movie movie = jdbcTemplate.queryForObject(sql, new MovieRowMapper(),code);
            movie.setActors(actorRepository.findAllByMovieCode(code));
            movie.setGenres(genreRepository.findAllByMovieCode(code));
            return Optional.of(movie);
        } catch (Exception e){
            // Crear mas catch para casos de fallos en el seteo de actores y genres
            return Optional.empty();
        }
    }
}
