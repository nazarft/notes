package com.fpmislata.MoviesStore.persistence.dao;

import com.fpmislata.MoviesStore.domain.model.Director;

import java.util.Optional;

public interface DirectorDao extends GenericDao<Director> {
    Optional<Director> findById(Long id);
}
