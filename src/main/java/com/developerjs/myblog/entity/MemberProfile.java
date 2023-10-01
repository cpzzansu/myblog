package com.developerjs.myblog.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="member_profile")
public class MemberProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Column(name = "stored_file_path", length = 500)
    private String storedFilePath;

    @Column(name = "image_source_path", length = 500)
    private String imageSourcePath;

    @Column(name = "file_size")
    private Long fileSize;

    @Column(name = "created_datetime")
    private String createdDatetime;

    @Column(name = "updated_datetime")
    private String updatedDatetime;

    public static MemberProfile createNewProfile() {
        return new MemberProfile();
    }
}
