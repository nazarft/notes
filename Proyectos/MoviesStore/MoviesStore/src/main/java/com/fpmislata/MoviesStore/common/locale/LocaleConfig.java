package com.fpmislata.MoviesStore.common.locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LocaleConfig implements WebMvcConfigurer {
    @Value("${app.language.default}")
    private String defaultLanguage;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomLocaleChangeInterceptor(defaultLanguage));
    }
}
