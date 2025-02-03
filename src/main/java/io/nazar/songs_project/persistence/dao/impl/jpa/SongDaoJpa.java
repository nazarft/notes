package io.nazar.songs_project.persistence.dao.impl.jpa;

import io.nazar.songs_project.domain.model.ListWithCount;
import io.nazar.songs_project.domain.model.Song;
import io.nazar.songs_project.persistence.dao.SongDao;
import io.nazar.songs_project.persistence.dao.impl.jpa.entity.SongEntity;
import io.nazar.songs_project.persistence.dao.impl.jpa.repository.SongJpaRepository;
import io.nazar.songs_project.persistence.dao.impl.jpa.mapper.SongJpaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SongDaoJpa implements SongDao {
    private final SongJpaRepository songJpaRepository;
    @Override
    public List<Song> findAll() {
        return songJpaRepository.findAll()
                .stream()
                .map(song -> SongJpaMapper.toSong(song))
                .toList();
    }

    @Override
    public ListWithCount<Song> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<SongEntity> songPage = songJpaRepository.findAll(pageable);

        return new ListWithCount<>(
                songPage
                        .stream()
                        .map(song -> SongJpaMapper.toSong(song))
                        .toList(),
                songPage.getTotalElements());
    }

    @Override
    public Optional<Song> findById(Long id) {
        return songJpaRepository.findById(id).map(song -> SongJpaMapper.toSong(song));
    }

    @Override
    public Song save(Song song) {
        SongEntity songEntity = SongJpaMapper.toSongEntity(song);
        return SongJpaMapper.toSong(songJpaRepository.save(songEntity));
    }
}
