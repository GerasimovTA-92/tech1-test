package com.example.tech1test.dto.response;

public class JwtResponseDto {
    private final String token;

    public JwtResponseDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
