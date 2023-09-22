package com.developerjs.myblog.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="member")
public class MemberEntity {

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
}
