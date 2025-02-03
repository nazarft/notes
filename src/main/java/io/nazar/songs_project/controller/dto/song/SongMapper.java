package io.nazar.songs_project.controller.dto.song;

import io.nazar.songs_project.controller.dto.singer.SingerMapper;
import io.nazar.songs_project.domain.model.Song;

public class SongMapper {



    public static SongListDTO toSongListDTO(Song song) {
        return new SongListDTO(song.getTitle(), song.getGenre());
    }
    public static SongDetailDTO toSongDetailDTO(Song song) {
        return new SongDetailDTO(
                song.getTitle(),
                song.getGenre(),
                song.getEditorial().getName(),
                song.getSingers().stream().map(singer -> SingerMapper.toSingerDto(singer)).toList());
    }

}
