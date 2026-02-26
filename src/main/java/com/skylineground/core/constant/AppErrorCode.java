package com.skylineground.core.constant;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum AppErrorCode {
    INVALID_JSON(HttpStatus.BAD_REQUEST),
    EMAIL_ALREADY_EXISTS(HttpStatus.CONFLICT);

    private final HttpStatus httpStatus;

    AppErrorCode(HttpStatus status) {
        this.httpStatus = status;
    }
}
