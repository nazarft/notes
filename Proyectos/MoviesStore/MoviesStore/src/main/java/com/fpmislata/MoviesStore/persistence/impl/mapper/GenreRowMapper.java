package com.fpmislata.MoviesStore.persistence.impl.mapper;

import com.fpmislata.MoviesStore.domain.model.Genre;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreRowMapper implements RowMapper<Genre> {
    @Override
    public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
        Genre genre = new Genre();
        genre.setId(rs.getInt("genres.id"));
        genre.setNameEs(rs.getString("genres.name_es"));
        genre.setNameEn(rs.getString("genres.name_en"));

        return genre;
    }
}
