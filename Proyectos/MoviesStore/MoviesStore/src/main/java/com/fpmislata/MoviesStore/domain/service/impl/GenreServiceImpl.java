package com.fpmislata.MoviesStore.domain.service.impl;

import com.fpmislata.MoviesStore.domain.model.Genre;
import com.fpmislata.MoviesStore.domain.repository.GenreRepository;
import com.fpmislata.MoviesStore.domain.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;
    @Override
    public List<Genre> getByMovieId(Long idMovie) {
        return genreRepository.getByMovieId(idMovie);
    }

    @Override
    public List<Genre> findAllById(List<Genre> genres) {
        List<Genre> foundGenres = genreRepository.findAllById(
                genres.stream()
                        .map(genre -> genre.getId())
                        .toArray(size -> new Long[size])
        );
        if(foundGenres.size() != genres.size()){
            throw new RuntimeException("Some genres were not found");
        }
        return foundGenres;
    }
}
