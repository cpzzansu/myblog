package com.developerjs.myblog.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "blog_title", length = 100)
    private String blogTitle;

    @Column(name = "blog_content", columnDefinition = "TEXT")
    private String blogContent;

    @Column(name = "member_email", nullable = false, length = 50)
    private String memberEmail;

    @Column(name = "blog_regist_time")
    private String blogRegistTime;

    @Column(name = "blog_update_time")
    private String blogUpdateTime;
}
