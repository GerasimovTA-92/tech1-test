package com.example.tech1test.controller;

import com.example.tech1test.dto.request.JwtRequestDto;
import com.example.tech1test.dto.response.JwtResponseDto;
import com.example.tech1test.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {
    private final JwtTokenProvider jwtTokenProvider;

    public JwtController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> createToken(@RequestBody JwtRequestDto requestDto)
            throws Exception {
        String token = jwtTokenProvider.createToken(requestDto.getUsername());
        return ResponseEntity.ok(new JwtResponseDto(token));
    }
}
