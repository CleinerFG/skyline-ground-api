package com.skylineground.core.exception;

import com.skylineground.core.constant.AppErrorCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ProblemDetail handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return buildProblemDetail(AppErrorCode.INVALID_JSON);
    }

    private ProblemDetail buildProblemDetail(AppErrorCode errorCode) {
        var problemDetail = ProblemDetail.forStatus(errorCode.getHttpStatus());
        problemDetail.setTitle(errorCode.name());
        return problemDetail;
    }
}
