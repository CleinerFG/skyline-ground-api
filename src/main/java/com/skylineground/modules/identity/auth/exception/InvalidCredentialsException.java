package com.skylineground.modules.identity.auth.exception;

import com.skylineground.core.exception.BusinessException;
import com.skylineground.modules.identity.IdentityErrorCode;

public class InvalidCredentialsException extends BusinessException {
    public InvalidCredentialsException() {
        super(IdentityErrorCode.INVALID_CREDENTIALS);
    }
}
