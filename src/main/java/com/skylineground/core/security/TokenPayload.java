package com.skylineground.core.security;

import lombok.Builder;

@Builder
public record TokenPayload(
        Long id,
        String email
) {
}
