package io.nazar.songs_project.domain.usecase.song.impl;

import io.nazar.songs_project.domain.model.Singer;
import io.nazar.songs_project.domain.model.Song;
import io.nazar.songs_project.domain.service.SingerService;
import io.nazar.songs_project.domain.service.SongService;
import io.nazar.songs_project.domain.usecase.song.SongFindByIdUseCase;
import io.nazar.songs_project.domain.usecase.song.SongInsertSingersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SongInsertSingersUseCaseImpl implements SongInsertSingersUseCase {
    private final SongService songService;
    private final SingerService singerService;
    @Override
    public void execute(Long songId, List<Singer> singers) {
        Song song = songService.findById(songId).orElseThrow(() -> new IllegalArgumentException("Song not found"));
        singerService
                .findAllById(singers)
                .forEach(song::addSinger);
        songService.save(song);
    }
}
