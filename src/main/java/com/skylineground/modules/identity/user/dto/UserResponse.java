package com.skylineground.modules.identity.user.dto;

import com.skylineground.modules.identity.user.SystemRole;
import lombok.Builder;

@Builder
public record UserResponse(
        Long id,
        String name,
        String email,
        SystemRole systemRole
) {
}
