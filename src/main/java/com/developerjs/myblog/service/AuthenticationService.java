package com.developerjs.myblog.service;

import com.developerjs.myblog.dto.LoginAccessTokenResponse;
import com.developerjs.myblog.entity.MemberEntity;
import com.developerjs.myblog.jwt.TokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;

@Service
@Transactional
@AllArgsConstructor
public class AuthenticationService {

    private AuthenticationManager authenticationManager;

    private TokenProvider tokenProvider;

    private MemberDetailsService memberDetailsService;
    public LoginAccessTokenResponse authenticateMember(String memberEmail, String memberPw){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(memberEmail, memberPw)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 사용자 정보를 가져와 토큰 생성
        MemberEntity member = (MemberEntity) authentication.getPrincipal();
        // 만료 시간은 예를 들어 Duration.ofHours(1) 등으로 설정
        LoginAccessTokenResponse loginAccessTokenResponse = new LoginAccessTokenResponse();
        loginAccessTokenResponse.setAccessToken(tokenProvider.generateToken(member, Duration.ofHours(1)));
        loginAccessTokenResponse.setRefreshToken(tokenProvider.generateToken(member, Duration.ofDays(1)));

        return loginAccessTokenResponse;
    }
}
