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
    private String titleEs;
    private String titleEn;
    private String synopsisEn;
    private String synopsisEs;
    private String image;
    private Director director;
    private ContentRating contentRating;
    private List<Actor> actors;
    private List<Genre> genres;

    public String getTitle(){
        String language = LanguageUtils.getCurrentLanguage();
        if("en".equals(language)){
            return titleEn;
        } else{
            return titleEs;
        }
    }
    @JsonIgnore
    public String getSynopsis(){
        String language = LanguageUtils.getCurrentLanguage();
        if("en".equals(language)){
            return synopsisEn;
        }
        return synopsisEs;
    }

}
