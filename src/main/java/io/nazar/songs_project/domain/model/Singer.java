package io.nazar.songs_project.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Singer {
    private Long id;
    private String name;
    private String country;
    private int age;
}
