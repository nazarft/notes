package io.nazar.songs_project.domain.usecase.song.impl;

import io.nazar.songs_project.domain.model.Song;
import io.nazar.songs_project.domain.repository.SongRepository;
import io.nazar.songs_project.domain.usecase.song.SongFindAllUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SongFindAllService implements SongFindAllUseCase {
    private final SongRepository songRepository;
    @Override
    public List<Song> execute() {
        return songRepository.findAll();
    }
}
