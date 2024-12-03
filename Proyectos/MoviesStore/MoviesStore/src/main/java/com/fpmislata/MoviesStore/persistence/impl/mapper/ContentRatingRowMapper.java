package com.fpmislata.MoviesStore.persistence.impl.mapper;

import com.fpmislata.MoviesStore.domain.model.ContentRating;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContentRatingRowMapper implements RowMapper<ContentRating> {
    @Override
    public ContentRating mapRow(ResultSet rs, int rowNum) throws SQLException {
        ContentRating contentRating = new ContentRating();
        contentRating.setId(rs.getInt("contentRatings.id"));
        contentRating.setRating(rs.getString("contentRatings.rating"));
        contentRating.setDescription(rs.getString("contentRatings.description"));

        return contentRating;
    }
}
