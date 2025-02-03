package io.nazar.songs_project.persistence.repository.impl;

import io.nazar.songs_project.domain.model.Singer;
import io.nazar.songs_project.domain.repository.SingerRepository;
import io.nazar.songs_project.persistence.dao.SingerDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class SingerRepositoryImpl implements SingerRepository {
    private final SingerDao singerDao;
    @Override
    public List<Singer> findAllById(List<Long> ids) {
        return singerDao.findAllById(ids);
    }
}
