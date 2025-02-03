package io.nazar.songs_project.domain.usecase.song;


import io.nazar.songs_project.domain.model.Song;

import java.util.List;

public interface SongFindAllUseCase {
    List<Song> execute();
}
