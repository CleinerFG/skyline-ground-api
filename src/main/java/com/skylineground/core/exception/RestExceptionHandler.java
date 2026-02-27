package com.skylineground.core.exception;

import com.skylineground.core.constant.AppErrorCode;
import com.skylineground.modules.identity.auth.InvalidCredentialsException;
import com.skylineground.modules.identity.user.EmailAlreadyExistsException;
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

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ProblemDetail handleEmailAlreadyExistsException(EmailAlreadyExistsException ex) {
        return buildProblemDetail(ex.getErrorCode());
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ProblemDetail handleInvalidCredentialsException(InvalidCredentialsException ex) {
        return buildProblemDetail(ex.getErrorCode());
    }

    private ProblemDetail buildProblemDetail(AppErrorCode errorCode) {
        var problemDetail = ProblemDetail.forStatus(errorCode.getHttpStatus());
        problemDetail.setTitle(errorCode.name());
        return problemDetail;
    }
}
