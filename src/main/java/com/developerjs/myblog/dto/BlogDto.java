package com.developerjs.myblog.dto;

import lombok.Data;

@Data
public class BlogDto {

    String blogTitle;
    String blogContent;
    String memberEmail;
    String blogRegistTime;
    String blogUpdateTime;
}
