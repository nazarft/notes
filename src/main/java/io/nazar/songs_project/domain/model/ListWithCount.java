package io.nazar.songs_project.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ListWithCount<T> {
    private List<T> list;
    private long count;
}
