package io.nazar.songs_project.persistence.dao.impl.jpa.mapper;

import io.nazar.songs_project.domain.model.Song;
import io.nazar.songs_project.persistence.dao.impl.jpa.entity.SongEntity;

public class SongJpaMapper {

    private static EditorialJpaMapper editorialJpaMapper = new EditorialJpaMapper(); // Initialize here
    private static SingerJpaMapper singerJpaMapper = new SingerJpaMapper(); // Initialize here

    public static Song toSong(SongEntity songEntity) {
        return new Song(
                songEntity.getId(),
                songEntity.getTitle(),
                songEntity.getGenre(),
                songEntity.getSingers() == null ? null : songEntity.getSingers().stream().map(singerJpaMapper::toDomain).toList(),
                songEntity.getEditorial() == null ? null : editorialJpaMapper.toDomain(songEntity.getEditorial()));
    }

    public static SongEntity toSongEntity(Song song) {
        return new SongEntity(
                song.getId(),
                song.getTitle(),
                song.getGenre(),
                song.getSingers() == null ? null : song.getSingers().stream().map(singerJpaMapper::toEntity).toList(),
                song.getEditorial() == null ? null : editorialJpaMapper.toEntity(song.getEditorial()));
    }
}
