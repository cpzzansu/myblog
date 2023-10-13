package com.developerjs.myblog.controller;

import com.developerjs.myblog.dto.CreateAccessTokenRequest;
import com.developerjs.myblog.dto.CreateAccessTokenResponse;
import com.developerjs.myblog.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://144.24.73.164:8088")
public class TokenApiController {

    private final TokenService tokenService;

    @PostMapping("/token")
    public ResponseEntity<CreateAccessTokenResponse> createNewAccessToken(@RequestBody String refreshToken){
        if(refreshToken.endsWith("=")){
            refreshToken = refreshToken.substring(0, refreshToken.length() - 1);
        }

        String newAccessToken = tokenService.createNewAccessToken(refreshToken);
        CreateAccessTokenResponse createAccessTokenResponse = new CreateAccessTokenResponse();
        createAccessTokenResponse.setAccessToken(newAccessToken);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAccessTokenResponse);
    }
}
