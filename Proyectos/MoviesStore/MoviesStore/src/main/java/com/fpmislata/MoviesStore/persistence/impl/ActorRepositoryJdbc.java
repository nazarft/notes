package com.fpmislata.MoviesStore.persistence.impl;

import com.fpmislata.MoviesStore.domain.model.Actor;
import com.fpmislata.MoviesStore.domain.repository.ActorRepository;
import com.fpmislata.MoviesStore.persistence.dao.ActorDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class ActorRepositoryJdbc implements ActorRepository {
    private final ActorDao actorDao;


    @Override
    public List<Actor> getByMovieId(Long idMovie) {
        return actorDao.getByMovieId(idMovie);
    }

    @Override
    public List<Actor> findAllById(Long[] ids) {
        return actorDao.findAllById(ids);
    }
}
