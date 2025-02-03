package io.nazar.songs_project.domain.usecase.song.impl;

import io.nazar.songs_project.domain.model.Song;
import io.nazar.songs_project.domain.repository.EditorialRepository;
import io.nazar.songs_project.domain.repository.SongRepository;
import io.nazar.songs_project.domain.service.SingerService;
import io.nazar.songs_project.domain.service.SongService;
import io.nazar.songs_project.domain.usecase.song.SongSaveUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SongSaveService implements SongSaveUseCase {
    private final SongService songService;
    private final EditorialRepository editorialRepository;
    private final SingerService singerService;

    @Override
    public Song execute(Song song) {
        if (song.getId() != null && songService.findById(song.getId()).isPresent()) {
            throw new IllegalArgumentException("Song already exists");
        }

        song.setEditorial(editorialRepository.findById(Long.valueOf(song.getEditorial().getId()))
                .orElseThrow(() -> new IllegalArgumentException("Editorial not found")));

        song.setSingers(singerService.findAllById(song.getSingers()));

        return songService.save(song);


    }
}
