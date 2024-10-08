package com.fpmislata.MoviesStore.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private String code;
    private String title_es;
    private String title_en;
    private String synopsis_en;
    private String synopsis_es;
    private String image;
    private Director director;
    private ContentRating contentRating;
    private List<Actor> actors;
    private List<Genre> genres;

}
