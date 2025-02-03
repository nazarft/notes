package io.nazar.songs_project.persistence.repository.impl;

import io.nazar.songs_project.domain.model.ListWithCount;
import io.nazar.songs_project.domain.model.Song;
import io.nazar.songs_project.domain.repository.SongRepository;
import io.nazar.songs_project.persistence.dao.SongDao;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SongRepositoryImpl implements SongRepository {
    private final SongDao songDao;
    @Override
    public List<Song> findAll() {
        return songDao.findAll();
    }

    @Override
    public ListWithCount<Song> findAll(int page, int size) {
        return songDao.findAll(page, size);
    }

    @Override
    public Optional<Song> findById(Long id) {
        return songDao.findById(id);
    }

    @Override
    public Song save(Song song) {
        return songDao.save(song);
    }
}
