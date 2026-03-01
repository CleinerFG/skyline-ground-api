package com.skylineground.core.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum GlobalErrorCode implements ErrorCode {

    INVALID_JSON("INVALID_JSON", HttpStatus.BAD_REQUEST);

    private final String code;
    private final HttpStatus httpStatus;
}
