package com.fpmislata.MoviesStore.domain.model;

import com.fpmislata.MoviesStore.common.locale.LanguageUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Genre {
    private long id;
    private String name_es;
    private String name_en;
    public String getName(){
        String language = LanguageUtils.getCurrentLanguage();
        if("en".equals(language)){
            return name_en;
        }
        return name_es;
    }
}
