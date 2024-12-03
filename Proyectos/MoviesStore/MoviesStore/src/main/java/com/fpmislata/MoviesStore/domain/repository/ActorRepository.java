package com.fpmislata.MoviesStore.domain.repository;

import com.fpmislata.MoviesStore.domain.model.Actor;

import java.util.List;

public interface ActorRepository {
    List<Actor> getByMovieId(Long idMovie);
    List<Actor> findAllById(Long[] ids);
}
