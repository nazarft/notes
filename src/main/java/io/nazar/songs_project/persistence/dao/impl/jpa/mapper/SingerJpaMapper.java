package io.nazar.songs_project.persistence.dao.impl.jpa.mapper;


import io.nazar.songs_project.domain.model.Singer;
import io.nazar.songs_project.persistence.dao.impl.jpa.entity.SingerEntity;

public class SingerJpaMapper {
    public Singer toDomain(SingerEntity singerEntity) {
        return new Singer(
                singerEntity.getId(),
                singerEntity.getName(),
                singerEntity.getCountry(),
                singerEntity.getAge());
    }
    public SingerEntity toEntity(Singer singer) {
        return new SingerEntity(
                singer.getId(),
                singer.getName(),
                singer.getCountry(),
                singer.getAge());
    }
}
