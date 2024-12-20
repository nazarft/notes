package com.fpmislata.MoviesStore.persistence.dao.impl.jdbc;

import com.fpmislata.MoviesStore.domain.model.Director;
import com.fpmislata.MoviesStore.domain.model.PageWithCount;
import com.fpmislata.MoviesStore.persistence.dao.DirectorDao;
import com.fpmislata.MoviesStore.persistence.impl.mapper.DirectorRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DirectorDaoImpl implements DirectorDao {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public Optional<Director> findById(Long id) {
        String sql = """
                SELECT * FROM director
                WHERE id = ?
                """;
        try{
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new DirectorRowMapper(), id));
        } catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public List<Director> getAll() {
        return List.of();
    }

    @Override
    public PageWithCount<Director> getAll(int page, int size) {
        return null;
    }

    @Override
    public long insert(Director director) {
        return 0;
    }

    @Override
    public void update(Director director) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void save(Director director) {
    }
}
