package io.nazar.songs_project.domain.service;

import io.nazar.songs_project.domain.model.ListWithCount;
import io.nazar.songs_project.domain.model.Singer;
import io.nazar.songs_project.domain.model.Song;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

public interface SongService {
    ListWithCount<Song> findAll(int page, int size);
    void addSinger(Song song, Singer singer);
    Optional<Song> findById(Long id);

    Song save(Song song);
}
