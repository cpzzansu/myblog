package com.developerjs.myblog.service;

import com.developerjs.myblog.dto.BlogDto;
import com.developerjs.myblog.entity.Blog;
import com.developerjs.myblog.repository.BlogRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@Transactional
@AllArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public ResponseEntity<?> addBlog(BlogDto blogDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        Blog blog = Blog.builder()
                .blogTitle(blogDto.getBlogTitle())
                .blogContent(blogDto.getBlogContent())
                .blogRegistTime(String.valueOf(LocalDateTime.now()))
                .memberEmail(userEmail)
                .build();

        blogRepository.save(blog);

        return ResponseEntity.ok("블로그 등록이 잘 되었습니다.");
    }
}
