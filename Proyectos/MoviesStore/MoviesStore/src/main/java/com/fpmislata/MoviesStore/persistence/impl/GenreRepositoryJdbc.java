package com.fpmislata.MoviesStore.persistence.impl;

import com.fpmislata.MoviesStore.domain.model.Genre;
import com.fpmislata.MoviesStore.domain.repository.GenreRepository;
import com.fpmislata.MoviesStore.persistence.dao.GenreDao;
import com.fpmislata.MoviesStore.persistence.impl.mapper.GenreRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GenreRepositoryJdbc implements GenreRepository {
    private final GenreDao genreDao;


    @Override
    public List<Genre> getByMovieId(Long idMovie) {
        return genreDao.getByMovieId(idMovie);
    }

    @Override
    public List<Genre> findAllById(Long[] ids) {
        return genreDao.findAllById(ids);
    }
}
