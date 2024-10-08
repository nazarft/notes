package com.fpmislata.MoviesStore.persistence.impl.mapper;

import com.fpmislata.MoviesStore.domain.model.ContentRating;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContentRatingRowMapper implements RowMapper<ContentRating> {
    @Override
    public ContentRating mapRow(ResultSet rs, int rowNum) throws SQLException {
        ContentRating contentRating = new ContentRating();
        contentRating.setId(rs.getInt("ContentRatings.id"));
        contentRating.setRating(rs.getString("ContentRatings.rating"));
        contentRating.setDescription(rs.getString("ContentRatings.description"));

        return contentRating;
    }
}
