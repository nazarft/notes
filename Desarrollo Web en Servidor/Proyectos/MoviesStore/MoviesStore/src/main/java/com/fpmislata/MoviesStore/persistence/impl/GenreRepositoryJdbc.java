package com.fpmislata.MoviesStore.persistence.impl;

import com.fpmislata.MoviesStore.domain.model.Genre;
import com.fpmislata.MoviesStore.domain.repository.GenreRepository;
import com.fpmislata.MoviesStore.persistence.impl.mapper.GenreRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GenreRepositoryJdbc implements GenreRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Genre> findAllByMovieCode(String code) {
        String sql = """
                SELECT genres.* from genres
                JOIN movies_genres ON genres.id = movies_genres.genre_id
                JOIN movies ON movies_genres.movie_id = movies.id
                WHERE movies.code = ?
                """;
        return jdbcTemplate.query(sql, new GenreRowMapper(), code);
    }
}
