package com.skylineground.modules.identity.user.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record UserSummary(
        UUID externalId,
        String name,
        String email
) {
}
