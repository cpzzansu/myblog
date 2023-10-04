package com.developerjs.myblog.service;

import com.developerjs.myblog.dto.BlogDto;
import com.developerjs.myblog.dto.MemberProfileDto;
import com.developerjs.myblog.entity.Blog;
import com.developerjs.myblog.entity.MemberProfile;
import com.developerjs.myblog.repository.BlogRepository;
import com.developerjs.myblog.repository.MemberProfileRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Transactional
@AllArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;
    private final MemberProfileRepository memberProfileRepository;

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

    public List<BlogDto> getBlog(){
        List<Blog> blogs = blogRepository.findAll();
        List<BlogDto> blogDtos = new ArrayList<>();
        for(Blog blog : blogs){
            BlogDto blogDto = new BlogDto();
            blogDto.setId(blog.getId());
            blogDto.setBlogTitle(blog.getBlogTitle());
            blogDto.setBlogContent(blog.getBlogContent());
            String writerEmail = blog.getMemberEmail();
            Optional<MemberProfile> memberProfile = memberProfileRepository.findByMemberEmail(writerEmail);
            if(memberProfile.isPresent()){
                MemberProfileDto memberProfileDto = new MemberProfileDto();
                memberProfileDto.setImageSourcePath(memberProfile.get().getImageSourcePath());
                memberProfileDto.setMemberName(memberProfile.get().getMemberName());
                memberProfileDto.setMemberCompanyName(memberProfile.get().getMemberCompanyName());
                memberProfileDto.setMemberDuty(memberProfile.get().getMemberDuty());
                blogDto.setMemberProfileDto(memberProfileDto);
            }
            blogDto.setBlogRegistTime(blog.getBlogRegistTime());

            blogDtos.add(blogDto);
        }

        return blogDtos;
    }
}
