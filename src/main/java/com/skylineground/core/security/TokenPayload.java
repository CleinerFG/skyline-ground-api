package com.skylineground.core.security;

import com.skylineground.modules.identity.user.SystemRole;
import lombok.Builder;

import java.util.UUID;

@Builder
public record TokenPayload(
        UUID externalId,
        SystemRole systemRole
) {
}
