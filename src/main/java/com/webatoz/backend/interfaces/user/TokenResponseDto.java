package com.webatoz.backend.interfaces.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenResponseDto {

    private String accessToken;
}
