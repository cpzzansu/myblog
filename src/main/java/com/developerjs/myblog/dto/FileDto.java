package com.developerjs.myblog.dto;

import lombok.Data;

@Data
public class FileDto {

    private String originalFileName;
    private String storedFilePath;
    private String imageSourcePath;
    private Long fileSize;

}
