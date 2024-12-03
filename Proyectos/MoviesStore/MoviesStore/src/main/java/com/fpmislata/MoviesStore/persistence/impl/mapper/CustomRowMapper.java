package com.fpmislata.MoviesStore.persistence.impl.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CustomRowMapper<T> extends RowMapper<T> {
    default boolean existsColumn (ResultSet rs, String columnName){
        try{
            rs.findColumn(columnName);
            return true;
        } catch (SQLException e){
            return false;
        }
    }
}
