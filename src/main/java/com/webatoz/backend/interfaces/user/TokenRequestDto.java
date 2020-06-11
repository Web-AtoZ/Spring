package com.webatoz.backend.interfaces.user;

import lombok.Data;

@Data
public class TokenRequestDto {
    private String email;

    private String secret;
}
