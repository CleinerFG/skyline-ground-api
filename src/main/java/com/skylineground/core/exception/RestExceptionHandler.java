package com.skylineground.core.exception;

import com.skylineground.core.constant.AppErrorCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    private ProblemDetail buildProblemDetail(AppErrorCode errorCode) {
        var problemDetail = ProblemDetail.forStatus(errorCode.getHttpStatus());
        problemDetail.setTitle(errorCode.name());
        return problemDetail;
    }
}
