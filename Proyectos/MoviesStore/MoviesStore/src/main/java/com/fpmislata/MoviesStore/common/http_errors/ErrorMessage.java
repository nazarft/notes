package com.fpmislata.MoviesStore.common.http_errors;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ErrorMessage {
    private final String error;
    private final String message;
    private final int code;


    public ErrorMessage(Exception exception, int code) {
        this.error = exception.getClass().getSimpleName();
        this.message = exception.getMessage();
        this.code = code;
    }
}
