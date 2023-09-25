package com.developerjs.myblog.service;

import com.developerjs.myblog.entity.MemberEntity;
import com.developerjs.myblog.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class memberDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public MemberEntity loadUserByUsername(String memberEmail){
        return memberRepository.findByEmail(memberEmail)
                .orElseThrow(() -> new IllegalArgumentException((memberEmail)));

    }
}
