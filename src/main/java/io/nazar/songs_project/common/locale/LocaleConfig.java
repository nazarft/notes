package io.nazar.songs_project.common.locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class LocaleConfig implements WebMvcConfigurer {
    @Value("${app.language.default}")
    private String defaultLanguage;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomLocalChangeInterceptor(defaultLanguage));
    }
}
