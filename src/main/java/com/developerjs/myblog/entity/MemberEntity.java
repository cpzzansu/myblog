package com.developerjs.myblog.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="member")
public class MemberEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, length = 50)
    private String memberEmail;

    @Column(nullable = false, length = 100)
    private String memberPw;

    @Column(nullable = false, updatable = false)
    @CreatedDate // Entity 생성 시간 자동 업데이트
    private LocalDateTime memberRegistTime = LocalDateTime.now();

    @Column(nullable = false)
    @LastModifiedDate // Entity 수정 시간 자동 업데이트
    private LocalDateTime memberUpdateTime = LocalDateTime.now();

    @Builder
    public MemberEntity(String memberEmail, String memberPw, String auth){
        this.memberEmail = memberEmail;
        this.memberPw = memberPw;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }
    @Override
    public String getUsername(){
        return memberEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public String getPassword(){
        return memberPw;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }



}
