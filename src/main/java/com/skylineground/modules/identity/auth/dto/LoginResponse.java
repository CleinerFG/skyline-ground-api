package com.skylineground.modules.identity.auth.dto;

public record LoginResponse(
        String token,
        String tokenType
) {
    public LoginResponse(String token) {
        this(token, "Bearer");
    }
}
