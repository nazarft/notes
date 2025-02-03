package io.nazar.songs_project.domain.usecase.song.impl;

import io.nazar.songs_project.domain.model.Song;
import io.nazar.songs_project.domain.repository.SongRepository;
import io.nazar.songs_project.domain.usecase.song.SongFindByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SongFindByIdService implements SongFindByIdUseCase {
    private final SongRepository songRepository;
    @Override
    public Song execute(Long id) {
        return songRepository.findById(id).orElse(null);
    }
}
