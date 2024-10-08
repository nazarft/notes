package com.fpmislata.MoviesStore.persistence.impl;

import com.fpmislata.MoviesStore.domain.model.Actor;
import com.fpmislata.MoviesStore.domain.repository.ActorRepository;
import com.fpmislata.MoviesStore.persistence.impl.mapper.ActorRowMapper;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class ActorRepositoryJdbc implements ActorRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Actor> findAllByMovieCode(String code) {
        String sql = """
                SELECT actors.* from actors
                JOIN movies_actors ON actors.id = movies_actors.actor_id
                JOIN movies ON movies_actors.movie_id = movies.id
                AND movies.code = ?
                """;
        return jdbcTemplate.query(sql, new ActorRowMapper(),code);
    }
}
