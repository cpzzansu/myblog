package com.developerjs.myblog.service;

import com.developerjs.myblog.entity.MemberEntity;
import com.developerjs.myblog.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String memberEmail){
        MemberEntity memberEntity;
        Optional<MemberEntity> member =
                memberRepository.findByEmail(memberEmail);
        if(member.isPresent()){
            memberEntity = member.get();
            return new MemberEntity(memberEntity.getEmail(), memberEntity.getPassword(), "?");
        }
        throw new UsernameNotFoundException("User Not Found");
    }


}