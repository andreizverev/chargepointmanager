package com.homecorp.chargepointmanager.api;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @Data
    @RequiredArgsConstructor
    public static class RestError {
        private final String errorMessage;
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<RestError> handle(IllegalArgumentException e) {
        return ResponseEntity.badRequest()
                .body(new RestError(e.getMessage()));
    }
}
