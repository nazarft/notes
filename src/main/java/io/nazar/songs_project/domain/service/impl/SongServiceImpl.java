package io.nazar.songs_project.domain.service.impl;

import io.nazar.songs_project.domain.model.ListWithCount;
import io.nazar.songs_project.domain.model.Singer;
import io.nazar.songs_project.domain.model.Song;
import io.nazar.songs_project.domain.repository.SongRepository;
import io.nazar.songs_project.domain.service.SingerService;
import io.nazar.songs_project.domain.service.SongService;
import io.nazar.songs_project.domain.usecase.song.SongFindByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;
    private final SingerService singerService;


    @Override
    public ListWithCount<Song> findAll(int page, int size) {
        return songRepository.findAll(page, size);
    }

    @Override
    public void addSinger(Song song, Singer singer) {
        if(song.getSingers() == null) {
            song.setSingers(new ArrayList<>());
        }
        if(song.getSingers().contains(singer)) {
            throw new IllegalArgumentException("Singer already exists");
        }
        song.addSinger(singer);
    }

    @Override
    public Optional<Song> findById(Long id) {
        return songRepository.findById(id);
    }

    @Override
    public Song save(Song song) {
        return songRepository.save(song);
    }
}
