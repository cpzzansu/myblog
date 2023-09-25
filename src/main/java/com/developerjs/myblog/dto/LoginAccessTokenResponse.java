package com.developerjs.myblog.dto;

import lombok.Data;

@Data
public class LoginAccessTokenResponse {
    private String accessToken;
    private String refreshToken;
}
