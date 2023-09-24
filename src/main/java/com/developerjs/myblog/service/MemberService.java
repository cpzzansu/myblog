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
        member.setMemberRegistTime(LocalDateTime.now());
        member.setMemberUpdateTime(LocalDateTime.now());

        MemberEntity memberEntity = MemberEntity.builder()
                .memberEmail(member.getMemberEmail())
                .memberPw(member.getMemberPw())
                .memberRegistTime(member.getMemberRegistTime())
                .memberUpdateTime(member.getMemberUpdateTime())
                .build();

        memberRepository.save(memberEntity);
    }
}
