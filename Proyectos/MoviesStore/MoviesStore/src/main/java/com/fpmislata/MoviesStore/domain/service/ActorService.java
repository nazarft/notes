package com.fpmislata.MoviesStore.domain.service;

import com.fpmislata.MoviesStore.domain.model.Actor;

import java.util.List;

public interface ActorService {
    List<Actor> getByMovieId(Long idMovie);
    List<Actor> findAllById(List<Actor> actors);
}
