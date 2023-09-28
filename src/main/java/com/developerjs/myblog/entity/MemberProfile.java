package com.developerjs.myblog.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="member_profile")
public class MemberProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "member_email", nullable = false, length = 50)
    private String memberEmail;

    @Column(name = "member_name", length = 50)
    private String memberName;

    @Column(name = "memberPhone", length = 50)
    private String memberPhone;

    @Column(name = "memberCompanyName", length = 50)
    private String memberCompanyName;

    @Column(name = "member_duty", length = 50)
    private String memberDuty;

    @Column(name = "member_biography", length = 100)
    private String memberBiography;

    @Column(name="original_file_name")
    private String originalFileName;

    @Column(name = "stored_file_name", length = 500)
    private String storedFileName;

    @Column(name = "file_size")
    private int fileSize;

}
