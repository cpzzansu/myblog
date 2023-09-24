package com.developerjs.myblog.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Member {
    private String memberEmail;
    private String memberPw;
    private LocalDateTime memberRegistTime;
    private LocalDateTime memberUpdateTime;
}
