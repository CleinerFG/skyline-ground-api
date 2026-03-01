package com.skylineground.core.exception;

import org.springframework.http.ProblemDetail;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ProblemDetail handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return buildProblemDetail(GlobalErrorCode.INVALID_JSON);
    }

    @ExceptionHandler(BusinessException.class)
    public ProblemDetail handleBusinessException(BusinessException ex) {
        return buildProblemDetail(ex.getErrorCode());
    }

    private ProblemDetail buildProblemDetail(ErrorCode errorCode) {
        var problemDetail = ProblemDetail.forStatus(errorCode.getHttpStatus());
        problemDetail.setTitle(errorCode.getCode());
        return problemDetail;
    }
}
