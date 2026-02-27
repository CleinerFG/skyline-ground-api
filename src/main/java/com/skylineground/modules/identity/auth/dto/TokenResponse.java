package com.skylineground.modules.identity.auth.dto;

public record TokenResponse(
        String token,
        String tokenType
) {
    public TokenResponse(String token) {
        this(token, "Bearer");
    }
}
