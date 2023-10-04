package com.developerjs.myblog.controller;

import com.developerjs.myblog.dto.BlogDto;
import com.developerjs.myblog.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class BlogController {

    private final BlogService blogService;

    @PostMapping("/private/blog")
    public ResponseEntity<?> addBlog(@RequestBody BlogDto blogDto){
        System.out.println(blogDto.toString());
        return blogService.addBlog(blogDto);
    }

//    @GetMapping("/private/blog")
//    public


    @GetMapping("/private/blog/{id}")
    public BlogDto getBlogDetail(@PathVariable Long id){



        return null;
    }
}
