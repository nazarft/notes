package io.nazar.songs_project.controller.dto.song;

import io.nazar.songs_project.controller.dto.singer.SingerListDTO;

import java.util.List;

public record SongDetailDTO(String title, String genre, String editorial, List<SingerListDTO> singers) {
}
