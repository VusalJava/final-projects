package com.amr.project.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    MODERATOR,
    USER,
    ANONYMOUS;

    @Override
    public String getAuthority() {
        return name();
    }
}