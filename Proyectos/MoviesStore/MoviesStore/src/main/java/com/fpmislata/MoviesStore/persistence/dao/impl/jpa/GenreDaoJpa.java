package com.fpmislata.MoviesStore.persistence.dao.impl.jpa;

import com.fpmislata.MoviesStore.domain.model.Genre;
import com.fpmislata.MoviesStore.domain.model.PageWithCount;
import com.fpmislata.MoviesStore.persistence.dao.GenreDao;
import com.fpmislata.MoviesStore.persistence.dao.impl.jpa.mapper.GenreJpaMapper;
import com.fpmislata.MoviesStore.persistence.dao.impl.jpa.repository.GenreJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
@Primary
@RequiredArgsConstructor
public class GenreDaoJpa implements GenreDao {
    private final GenreJpaRepository genreJpaRepository;
    @Override
    public List<Genre> getByMovieId(Long idMovie) {
        return genreJpaRepository.findByMoviesId(idMovie)
                .stream()
                .map(genre -> GenreJpaMapper.INSTANCE.toGenre(genre))
                .toList();
    }

    @Override
    public List<Genre> findAllById(Long[] ids) {
        return genreJpaRepository.findAllById(List.of(ids))
                .stream()
                .map(genre -> GenreJpaMapper.INSTANCE.toGenre(genre))
                .toList();
    }

    @Override
    public List<Genre> getAll() {
        return List.of();
    }

    @Override
    public PageWithCount<Genre> getAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<Genre> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public long insert(Genre genre) {
        return 0;
    }

    @Override
    public void update(Genre genre) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void save(Genre genre) {

    }
}
