package com.developerjs.myblog.controller;

import com.developerjs.myblog.dto.BlogDto;
import com.developerjs.myblog.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://144.24.73.164:8088")
public class BlogController {

    private final BlogService blogService;

    @PostMapping("/private/blog")
    public ResponseEntity<?> addBlog(@RequestBody BlogDto blogDto){
        System.out.println(blogDto.toString());
        return blogService.addBlog(blogDto);
    }

    @GetMapping("/private/blog")
    public List<BlogDto> getBlog(){
        return blogService.getBlog();
    }


    @GetMapping("/private/blog/{id}")
    public BlogDto getBlogDetail(@PathVariable Long id){
        return blogService.getBlogDetail(id);
    }

    @PostMapping("/private/blog/image")
    public ResponseEntity<?> addBlogImage(@RequestParam(name = "image") MultipartFile image) throws Exception {
        return blogService.addBlogImage(image);
    }
}
