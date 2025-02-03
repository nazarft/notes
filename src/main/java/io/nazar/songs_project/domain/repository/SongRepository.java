package io.nazar.songs_project.domain.repository;


import io.nazar.songs_project.domain.model.ListWithCount;
import io.nazar.songs_project.domain.model.Song;
import org.hibernate.query.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SongRepository {
    List<Song> findAll();
    ListWithCount<Song> findAll(int page,int size);
    Optional<Song> findById(Long id);
    Song save(Song song);
}
