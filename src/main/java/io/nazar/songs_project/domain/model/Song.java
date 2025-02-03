package io.nazar.songs_project.domain.model;

import io.nazar.songs_project.common.annotations.ValidTitle;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Song {
    private Long id;
    @ValidTitle
    private String title;
    private String genre;
    private List<Singer> singers;
    private Editorial editorial;

    public void addSinger(Singer singer){
        this.singers.add(singer);
    }
}
