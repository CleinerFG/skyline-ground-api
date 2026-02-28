package com.skylineground.modules.identity.user.dto;

import com.skylineground.modules.identity.user.SystemRole;
import lombok.Builder;

import java.util.UUID;

@Builder
public record UserResponse(
        UUID externalId,
        String name,
        String email,
        SystemRole systemRole
) {
}
