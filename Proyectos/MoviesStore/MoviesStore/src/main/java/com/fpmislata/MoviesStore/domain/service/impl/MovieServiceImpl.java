package com.fpmislata.MoviesStore.domain.service.impl;

import com.fpmislata.MoviesStore.domain.model.Movie;
import com.fpmislata.MoviesStore.domain.model.PageWithCount;
import com.fpmislata.MoviesStore.domain.repository.MovieRepository;
import com.fpmislata.MoviesStore.domain.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public PageWithCount<Movie> getAll(int page, int size) {
        return movieRepository.getAll(page, size);
    }

    @Override
    public Optional<Movie> findByCode(String code) {
        return movieRepository.findByCode(code);
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return null;
    }

    @Override
    public int count() {
        return movieRepository.count();
    }

    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void delete(Long id) {
        movieRepository.delete(id);
    }
}
