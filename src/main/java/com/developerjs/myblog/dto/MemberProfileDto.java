package com.developerjs.myblog.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Data
public class MemberProfileDto {
    private String memberEmail;
    private String memberName;
    private String memberPhone;
    private String memberCompanyName;
    private String memberDuty;
    private String memberBiography;
    private String imageSourcePath;
    private MultipartFile memberProfilePicture;
}
