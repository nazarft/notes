package com.fpmislata.MoviesStore.persistence.impl.mapper;

import com.fpmislata.MoviesStore.domain.model.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements CustomRowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {

        DirectorRowMapper directorRowMapper = new DirectorRowMapper();
        ContentRatingRowMapper contentRatingRowMapper = new ContentRatingRowMapper();

        Movie movie = new Movie();
        movie.setId(rs.getLong("movies.id"));
        movie.setCode(rs.getString("movies.code"));
        movie.setTitle_es(rs.getString("movies.title_es"));
        movie.setTitle_en(rs.getString("movies.title_en"));
        movie.setSynopsis_es(rs.getString("movies.synopsis_es"));
        movie.setSynopsis_en(rs.getString("movies.synopsis_en"));
        movie.setImage(rs.getString("movies.image"));
        if(this.existsColumn(rs, "director.id")){
            movie.setDirector(directorRowMapper.mapRow(rs,rowNum));
        }
        if (this.existsColumn(rs,"ContentRatings.id")){
            movie.setContentRating(contentRatingRowMapper.mapRow(rs,rowNum));
        }

        return movie;
    }
}
