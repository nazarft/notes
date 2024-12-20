package com.fpmislata.MoviesStore.persistence.impl;

import com.fpmislata.MoviesStore.domain.model.Movie;
import com.fpmislata.MoviesStore.domain.model.PageWithCount;
import com.fpmislata.MoviesStore.domain.repository.ActorRepository;
import com.fpmislata.MoviesStore.domain.repository.GenreRepository;
import com.fpmislata.MoviesStore.domain.repository.MovieRepository;
import com.fpmislata.MoviesStore.persistence.dao.MovieDao;
import com.fpmislata.MoviesStore.persistence.impl.mapper.MovieRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
@RequiredArgsConstructor
public class MovieRepositoryJdbc implements MovieRepository {
    private final MovieDao movieDao;

    @Override
    public PageWithCount<Movie> getAll(Integer page, Integer size) {
        return movieDao.getAll(page, size);
    }

    @Override
    public Optional<Movie> findByCode(String code) {
        return movieDao.findByCode(code);
    }

    @Override
    public int count() {
        return movieDao.count();
    }

    @Override
    public void save(Movie movie) {
        movieDao.save(movie);
    }

    @Override
    public void delete(Long id) {
        movieDao.delete(id);
    }
}
