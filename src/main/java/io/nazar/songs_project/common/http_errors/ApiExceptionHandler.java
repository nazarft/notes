package io.nazar.songs_project.common.http_errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RuntimeException.class)
    public ErrorMessage notFoundRequest(RuntimeException exception) {
        return new ErrorMessage(exception, HttpStatus.NOT_FOUND.value());
    }
}
