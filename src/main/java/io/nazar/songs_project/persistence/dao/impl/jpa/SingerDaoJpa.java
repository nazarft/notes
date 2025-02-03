package io.nazar.songs_project.persistence.dao.impl.jpa;

import io.nazar.songs_project.domain.model.Singer;
import io.nazar.songs_project.persistence.dao.SingerDao;
import io.nazar.songs_project.persistence.dao.impl.jpa.mapper.SingerJpaMapper;
import io.nazar.songs_project.persistence.dao.impl.jpa.repository.SingerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SingerDaoJpa implements SingerDao {
    private final SingerJpaRepository singerJpaRepository;
    private static final SingerJpaMapper singerJpaMapper = new SingerJpaMapper();
    @Override
    public List<Singer> findAllById(List<Long> ids) {
        return singerJpaRepository.findAllById(ids).stream().map(singerEntity -> singerJpaMapper.toDomain(singerEntity)).toList();
    }
}
