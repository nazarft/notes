package io.nazar.songs_project.controller;

import io.nazar.songs_project.controller.common.PaginatedResponse;
import io.nazar.songs_project.controller.dto.song.SongDetailDTO;
import io.nazar.songs_project.controller.dto.song.SongListDTO;
import io.nazar.songs_project.controller.dto.song.SongMapper;
import io.nazar.songs_project.domain.model.ListWithCount;
import io.nazar.songs_project.domain.model.Song;
import io.nazar.songs_project.domain.service.SongService;
import io.nazar.songs_project.domain.usecase.song.SongFindAllUseCase;
import io.nazar.songs_project.domain.usecase.song.SongFindByIdUseCase;
import io.nazar.songs_project.domain.usecase.song.SongSaveUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SongController {
    private final SongService songService;
    private final SongFindAllUseCase songFindAllUseCase;
    private final SongFindByIdUseCase songFindByIdUseCase;
    private final SongSaveUseCase songSaveUseCase;

    @Value("${app.pageSize.default}")
    private String defaultPageSize;

    @Value("${app.base.url}")
    private String baseUrl;

    public static final String URL = "/songs";

    @GetMapping("/songs")
    public ResponseEntity<PaginatedResponse<SongListDTO>> findAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size
    ) {
                int pageSize = (size != null) ? size : Integer.parseInt(defaultPageSize);
        ListWithCount<Song> songs = songService.findAll(page - 1, pageSize);
        PaginatedResponse<SongListDTO> response = new PaginatedResponse<>(
                songs
                        .getList()
                        .stream()
                        .map(SongMapper::toSongListDTO)
                        .toList(),
                songs.getCount(), page, pageSize, baseUrl + URL);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/songs/{id}")
    public ResponseEntity<SongDetailDTO> findById(@PathVariable  Long id) {
        return ResponseEntity.ok(SongMapper.toSongDetailDTO(songFindByIdUseCase.execute(id)));
    }

    @PostMapping("/songs")
    public ResponseEntity<Song> save(@RequestBody Song song) {
        return ResponseEntity.ok(songSaveUseCase.execute(song));
    }
}
