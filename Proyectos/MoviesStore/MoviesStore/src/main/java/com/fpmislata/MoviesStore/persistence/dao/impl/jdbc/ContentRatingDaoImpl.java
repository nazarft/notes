package com.fpmislata.MoviesStore.persistence.dao.impl.jdbc;

import com.fpmislata.MoviesStore.domain.model.ContentRating;
import com.fpmislata.MoviesStore.persistence.dao.ContentRatingDao;
import com.fpmislata.MoviesStore.persistence.impl.mapper.ContentRatingRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ContentRatingDaoImpl implements ContentRatingDao {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public Optional<ContentRating> findById(Long id) {
        String sql = """
                SELECT * FROM ContentRatings
                WHERE id = ?
                """;
        try{
            return Optional.of(jdbcTemplate.queryForObject(sql, new ContentRatingRowMapper(), id));
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public List<ContentRating> getAll() {
        return List.of();
    }

    @Override
    public List<ContentRating> getAll(int page, int size) {
        return List.of();
    }


    @Override
    public long insert(ContentRating contentRating) {
        return 0;
    }

    @Override
    public void update(ContentRating contentRating) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void save(ContentRating contentRating) {
    }
}
