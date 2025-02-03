package io.nazar.songs_project.domain.usecase.song;


import io.nazar.songs_project.domain.model.Song;

public interface SongFindByIdUseCase {
    Song execute(Long id);
}
