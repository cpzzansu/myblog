package com.developerjs.myblog.dto;

import lombok.Data;

@Data
public class MemberLoginRequest {

    private String memberEmail;
    private String memberPw;
}
