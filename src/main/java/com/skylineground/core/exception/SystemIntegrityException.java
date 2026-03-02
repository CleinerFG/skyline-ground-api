package com.skylineground.core.exception;

public class SystemIntegrityException extends BusinessException {
    public SystemIntegrityException() {
        super(GlobalErrorCode.SYSTEM_INTEGRITY_VIOLATION);
    }
}
