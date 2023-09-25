package com.developerjs.myblog.service;

import com.developerjs.myblog.entity.MemberEntity;
import com.developerjs.myblog.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class TokenService {

    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final MemberService memberService;

    public String createNewAccessToken(String refreshToken) {
        // 토큰 유효성 검사에 실패하면 예외 발생
        if(!tokenProvider.validToken(refreshToken)){
            throw new IllegalArgumentException("Unexpected token");
        }

        Long memberId = refreshTokenService.findByRefreshToken(refreshToken).getMemberId();
        MemberEntity memberEntity = memberService.findByMemberId(memberId);

        return tokenProvider.generateToken(memberEntity, Duration.ofHours(2));
    }
}
