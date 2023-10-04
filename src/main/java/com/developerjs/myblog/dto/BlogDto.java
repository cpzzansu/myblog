package com.developerjs.myblog.dto;

import com.developerjs.myblog.entity.MemberProfile;
import lombok.Data;

@Data
public class BlogDto {

    private Long id;
    private String blogTitle;
    private String blogContent;
    private String memberEmail;
    private String blogRegistTime;
    private String blogUpdateTime;

    private MemberProfileDto memberProfileDto;
}
