package io.nazar.songs_project.domain.usecase.song;


import io.nazar.songs_project.domain.model.Song;

public interface SongSaveUseCase {
    Song execute(Song song);
}
