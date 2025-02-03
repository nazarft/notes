package io.nazar.songs_project.controller.dto.singer;

import io.nazar.songs_project.domain.model.Singer;

import java.util.List;

public class SingerMapper {
    public static List<SingerListDTO> toSingerListDto (List<Singer> singers) {
        return singers.stream().map(singer -> SingerMapper.toSingerDto(singer)).toList();
    }
    public static SingerListDTO toSingerDto (Singer singer) {
        return new SingerListDTO(singer.getName(), singer.getAge());
    }

}
