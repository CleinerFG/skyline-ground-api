package com.skylineground.modules.identity.user;

import com.skylineground.core.constant.AppErrorCode;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException() {
        super(AppErrorCode.EMAIL_ALREADY_EXISTS.name());
    }

    public AppErrorCode getErrorCode() {
        return AppErrorCode.EMAIL_ALREADY_EXISTS;
    }
}
