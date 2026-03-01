package com.skylineground.core.exception;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public interface ErrorCode extends Serializable {
    String getCode();

    HttpStatus getHttpStatus();
}
