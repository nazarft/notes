package io.nazar.songs_project.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Editorial {
    private Integer id;
    private String name;
    private String country;
}
