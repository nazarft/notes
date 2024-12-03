package com.fpmislata.MoviesStore.domain.model;

import com.fpmislata.MoviesStore.common.locale.LanguageUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
    private long id;
    private String name;
    private String nationality;
    private String biography_en;
    private String biography_es;

    public String getBiography(){
        String language = LanguageUtils.getCurrentLanguage();
        if ("en".equals(language)) {
            return biography_en;
        }
        return biography_es;
        }
}