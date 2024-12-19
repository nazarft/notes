package com.fpmislata.MoviesStore.persistence.dao;

import com.fpmislata.MoviesStore.domain.model.Actor;

import java.util.List;

public interface ActorDao extends GenericDao<Actor> {
    List<Actor> getByMovieId(Long idMovie);
    List<Actor> findAllById(Long[] ids);
}
