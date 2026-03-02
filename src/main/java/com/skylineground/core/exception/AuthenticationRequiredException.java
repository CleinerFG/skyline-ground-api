package com.skylineground.core.exception;

public class AuthenticationRequiredException extends BusinessException {
    public AuthenticationRequiredException() {
        super(GlobalErrorCode.AUTHENTICATION_REQUIRED);
    }
}
