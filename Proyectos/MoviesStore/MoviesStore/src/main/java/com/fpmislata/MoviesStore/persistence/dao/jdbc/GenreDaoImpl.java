package com.fpmislata.MoviesStore.persistence.dao.jdbc;

import com.fpmislata.MoviesStore.domain.model.Genre;
import com.fpmislata.MoviesStore.persistence.dao.GenreDao;
import com.fpmislata.MoviesStore.persistence.impl.mapper.GenreRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class GenreDaoImpl implements GenreDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public List<Genre> getByMovieId(Long idMovie) {
        String sql = """
                SELECT * FROM genres
                INNER JOIN movies_genres ON genres.id = movies_genres.genre_id
                WHERE movies_genres.movie_id = ?
                """;
        return jdbcTemplate.query(sql, new GenreRowMapper(), idMovie);
    }

    @Override
    public List<Genre> findAllById(Long[] ids) {
        String sql = """
                SELECT * FROM genres
                WHERE id IN (:ids)
                """;
        List<Long> idList = List.of(ids);
        Map<String, Object> params = Map.of("ids", idList);
        return namedParameterJdbcTemplate.query(sql, params, new GenreRowMapper());
    }
}
