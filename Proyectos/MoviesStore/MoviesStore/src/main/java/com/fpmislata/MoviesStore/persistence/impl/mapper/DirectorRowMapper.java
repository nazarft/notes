package com.fpmislata.MoviesStore.persistence.impl.mapper;

import com.fpmislata.MoviesStore.domain.model.Director;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DirectorRowMapper implements RowMapper<Director> {
    @Override
    public Director mapRow(ResultSet rs, int rowNum) throws SQLException {
        Director director = new Director();
        director.setId(rs.getInt("director.id"));
        director.setName(rs.getString("director.name"));
        director.setNationality(rs.getString("director.nationality"));
        director.setBiography_es(rs.getString("director.biography_es"));
        director.setBiography_en(rs.getString("director.biography_en"));
        director.setBirthYear(rs.getInt("director.birth_year"));

        return director;
    }
}
