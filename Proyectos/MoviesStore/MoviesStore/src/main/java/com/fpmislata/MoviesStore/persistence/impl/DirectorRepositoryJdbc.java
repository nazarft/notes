package com.fpmislata.MoviesStore.persistence.impl;

import com.fpmislata.MoviesStore.domain.model.Director;
import com.fpmislata.MoviesStore.domain.repository.DirectorRepository;
import com.fpmislata.MoviesStore.persistence.dao.DirectorDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@RequiredArgsConstructor
public class DirectorRepositoryJdbc implements DirectorRepository {
    private final DirectorDao directorDao;
    @Override
    public Optional<Director> findById(Long id) {
        return directorDao.findById(id);
    }
}
