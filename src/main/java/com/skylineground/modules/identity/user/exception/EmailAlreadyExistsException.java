package com.skylineground.modules.identity.user.exception;

import com.skylineground.core.exception.BusinessException;
import com.skylineground.modules.identity.IdentityErrorCode;

public class EmailAlreadyExistsException extends BusinessException {

    public EmailAlreadyExistsException() {
        super(IdentityErrorCode.EMAIL_ALREADY_EXISTS);
    }
}
