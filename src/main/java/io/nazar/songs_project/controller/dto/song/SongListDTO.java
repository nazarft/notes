package io.nazar.songs_project.controller.dto.song;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record SongListDTO(
        String title,
        String genre) {
}