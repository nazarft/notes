package com.fpmislata.MoviesStore.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContentRating {
    private long id;
    private String rating;
    private String description;

}
