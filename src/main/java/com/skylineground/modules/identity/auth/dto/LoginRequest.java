package com.skylineground.modules.identity.auth.dto;

public record LoginRequest(
        String email,
        String password
) {
}
