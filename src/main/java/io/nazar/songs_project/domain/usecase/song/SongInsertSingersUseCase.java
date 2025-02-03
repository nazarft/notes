package io.nazar.songs_project.domain.usecase.song;

import io.nazar.songs_project.domain.model.Singer;
import io.nazar.songs_project.domain.model.Song;

import java.util.List;

public interface SongInsertSingersUseCase {
    void execute(Long songId, List<Singer> singers);
}
