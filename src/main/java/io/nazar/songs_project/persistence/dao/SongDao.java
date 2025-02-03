package io.nazar.songs_project.persistence.dao;

import io.nazar.songs_project.domain.model.ListWithCount;
import io.nazar.songs_project.domain.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongDao {
    List<Song> findAll();
    ListWithCount<Song> findAll(int page, int size);
    Optional<Song> findById(Long id);
    Song save(Song song);
}
