package com.developerjs.myblog.service;

import com.developerjs.myblog.jwt.TokenProvider;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@AllArgsConstructor
@Service
public class AuthenticationService {

    private TokenProvider tokenProvider;

    private AuthenticationManager authenticationManager;


}
