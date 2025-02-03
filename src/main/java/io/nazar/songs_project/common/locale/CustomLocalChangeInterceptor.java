package io.nazar.songs_project.common.locale;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

public class CustomLocalChangeInterceptor extends LocaleChangeInterceptor {

    private final String defaultLanguage;


    public CustomLocalChangeInterceptor(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {

        String lang = request.getHeader("Accept-Language");
        Locale locale = lang != null ? Locale.forLanguageTag(lang) : new Locale(defaultLanguage);
        LanguageUtils.setCurrentLocale(locale);

        return super.preHandle(request, response, handler);
    }
}
