package com.skylineground.modules.identity.auth;

import com.skylineground.core.constant.AppErrorCode;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException() {
        super(AppErrorCode.INVALID_CREDENTIALS.name());
    }

   public AppErrorCode getErrorCode(){
        return AppErrorCode.INVALID_CREDENTIALS;
   }
}
