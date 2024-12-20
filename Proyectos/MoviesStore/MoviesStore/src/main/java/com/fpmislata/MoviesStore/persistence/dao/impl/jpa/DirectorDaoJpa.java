package com.fpmislata.MoviesStore.persistence.dao.impl.jpa;

import com.fpmislata.MoviesStore.domain.model.Director;
import com.fpmislata.MoviesStore.domain.model.PageWithCount;
import com.fpmislata.MoviesStore.persistence.dao.DirectorDao;
import com.fpmislata.MoviesStore.persistence.dao.impl.jpa.mapper.DirectorJpaMapper;
import com.fpmislata.MoviesStore.persistence.dao.impl.jpa.repository.DirectorJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
@Primary
@RequiredArgsConstructor
public class DirectorDaoJpa implements DirectorDao {
    private final DirectorJpaRepository directorJpaRepository;
    @Override
    public Optional<Director> findById(Long id) {
        return directorJpaRepository.findById(id)
                .map(director -> DirectorJpaMapper.INSTANCE.toDirector(director));
    }
    @Override
    public List<Director> getAll() {
        return List.of();
    }

    @Override
    public PageWithCount<Director> getAll(int page, int size) {
        return null;
    }


    @Override
    public long insert(Director director) {
        return 0;
    }

    @Override
    public void update(Director director) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void save(Director director) {

    }
}
