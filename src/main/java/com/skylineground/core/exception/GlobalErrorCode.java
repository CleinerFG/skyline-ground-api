package com.skylineground.core.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum GlobalErrorCode implements ErrorCode {

    INVALID_JSON("INVALID_JSON", HttpStatus.BAD_REQUEST),
    AUTHENTICATION_REQUIRED("AUTHENTICATION_REQUIRED", HttpStatus.UNAUTHORIZED),
    SYSTEM_INTEGRITY_VIOLATION("SYSTEM_INTEGRITY_VIOLATION", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String code;
    private final HttpStatus httpStatus;
}
