package com.fpmislata.MoviesStore.persistence.impl.mapper;


import com.fpmislata.MoviesStore.domain.model.Actor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActorRowMapper implements RowMapper<Actor> {

    @Override
    public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Actor actor = new Actor();
        actor.setId(rs.getInt("actors.id"));
        actor.setName(rs.getString("actors.name"));
        actor.setNationality(rs.getString("actors.nationality"));
        actor.setBiographyEs(rs.getString("actors.biography_es"));
        actor.setBiographyEn(rs.getString("actors.biography_en"));

        return actor;
    }
}
