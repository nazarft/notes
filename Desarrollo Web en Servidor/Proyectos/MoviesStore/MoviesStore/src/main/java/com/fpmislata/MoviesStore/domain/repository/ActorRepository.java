package com.fpmislata.MoviesStore.domain.repository;

import com.fpmislata.MoviesStore.domain.model.Actor;

import java.util.List;

public interface ActorRepository {
    List<Actor> findAllByMovieCode(String code);
}
