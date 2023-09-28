package com.developerjs.myblog.dto;

import lombok.Data;

import java.io.File;

@Data
public class MemberProfileDto {
    private String memberEmail;
    private String memberName;
    private String memberCompanyName;
    private String memberDuty;
    private String memberBiography;
    private File profilePicture;
}
