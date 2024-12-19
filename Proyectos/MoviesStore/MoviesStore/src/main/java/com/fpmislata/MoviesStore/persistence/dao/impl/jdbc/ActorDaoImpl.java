package com.fpmislata.MoviesStore.persistence.dao.impl.jdbc;

import com.fpmislata.MoviesStore.domain.model.Actor;
import com.fpmislata.MoviesStore.persistence.dao.ActorDao;
import com.fpmislata.MoviesStore.persistence.impl.mapper.ActorRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ActorDaoImpl implements ActorDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public List<Actor> getByMovieId(Long idMovie) {
        String sql = """
                SELECT * FROM actors
                INNER JOIN movies_actors ON actors.id = movies_actors.actor_id
                WHERE movies_actors.movie_id = ?
                """;
        return jdbcTemplate.query(sql, new ActorRowMapper(), idMovie);
    }

    @Override
    public List<Actor> findAllById(Long[] ids) {
        String sql = """
                SELECT * FROM actors
                WHERE id IN (:ids)
                """;
        List<Long> idList = Arrays.asList(ids);
        Map<String, Object> params = Map.of("ids", idList);
        return namedParameterJdbcTemplate.query(sql, params, new ActorRowMapper());
    }

    @Override
    public List<Actor> getAll() {
        return List.of();
    }

    @Override
    public List<Actor> getAll(int page, int size) {
        return List.of();
    }

    @Override
    public Optional<Actor> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public long insert(Actor actor) {
        return 0;
    }

    @Override
    public void update(Actor actor) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void save(Actor actor) {
    }
}
