package com.developerjs.myblog.service;

import com.developerjs.myblog.dto.Member;
import com.developerjs.myblog.entity.MemberEntity;
import com.developerjs.myblog.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@Transactional
@AllArgsConstructor
@Service
public class MemberService {

    MemberRepository memberRepository;

    private PasswordEncoder passwordEncoder;

    public void save(Member member){

        member.setMemberPw(passwordEncoder.encode(member.getMemberPw()));

        MemberEntity memberEntity = MemberEntity.builder()
                .email(member.getMemberEmail())
                .password(member.getMemberPw())
                .build();

        memberRepository.save(memberEntity);
    }

    public MemberEntity findByMemberId(Long memberId){
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected member"));
    }
}
