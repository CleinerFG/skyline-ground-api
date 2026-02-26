package com.skylineground.modules.identity.user.dto;

public record UserRequest(
        String name,
        String email,
        String password
) {
}
