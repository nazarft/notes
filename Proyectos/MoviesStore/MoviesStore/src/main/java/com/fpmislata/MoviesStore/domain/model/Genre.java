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
    private String nameEs;
    private String nameEn;
    public String getName(){
        String language = LanguageUtils.getCurrentLanguage();
        if("en".equals(language)){
            return nameEn;
        }
        return nameEs;
    }
}
