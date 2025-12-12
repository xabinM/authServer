package com.temp.backend.global.exception.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorResponse {

    private final int code;
    private final String message;

    public ErrorResponse(HttpStatus status, String message) {
        this.code = status.value();
        this.message = message;
    }
}
