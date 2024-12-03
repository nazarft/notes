package com.fpmislata.MoviesStore.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fpmislata.MoviesStore.common.locale.LanguageUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private Long id;
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
    @JsonIgnore
    public String getTitle(){
        String language = LanguageUtils.getCurrentLanguage();
        if("en".equals(language)){
            return title_en;
        } else{
            return title_es;
        }
    }
    @JsonIgnore
    public String getSynopsis(){
        String language = LanguageUtils.getCurrentLanguage();
        if("en".equals(language)){
            return synopsis_en;
        }
        return synopsis_es;
    }

}
