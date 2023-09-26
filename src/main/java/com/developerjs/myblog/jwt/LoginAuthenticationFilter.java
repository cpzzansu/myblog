package com.developerjs.myblog.jwt;

import com.developerjs.myblog.dto.Member;
import com.developerjs.myblog.dto.MemberLoginRequest;
import com.developerjs.myblog.entity.MemberEntity;
import com.developerjs.myblog.repository.MemberRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Optional;

@RequiredArgsConstructor
public class LoginAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private TokenProvider tokenProvider;
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response){
        try {

            MemberLoginRequest memberLoginRequest = new ObjectMapper()
                    .readValue(request.getInputStream(), MemberLoginRequest.class);

            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            memberLoginRequest.getMemberEmail(),
                            memberLoginRequest.getMemberPw(),
                            new ArrayList<>())
            );
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException{

        String username = authResult.getName();
        Optional<MemberEntity> memberEntity = memberRepository.findByEmail(username);
        if(!memberEntity.isPresent()){
            throw new UsernameNotFoundException(username);
        }
        MemberEntity member = memberEntity.get();
        // 액세스 토큰 발행
        String accessToken = tokenProvider.generateToken(member, Duration.ofHours(2));

        // 리프레시 토큰 발행 (일반적으로 리프레시 토큰의 수명은 액세스 토큰보다 길게 설정)
        String refreshToken = tokenProvider.generateToken(member, Duration.ofDays(30));

        response.addHeader("accesstoken", accessToken);
        response.addHeader("refreshtoken", refreshToken);
        response.addHeader("memberid", member.getEmail());
    }
}
