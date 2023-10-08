package com.developerjs.myblog.service;

import com.developerjs.myblog.common.FileUtils;
import com.developerjs.myblog.dto.BlogDto;
import com.developerjs.myblog.dto.MemberProfileDto;
import com.developerjs.myblog.entity.Blog;
import com.developerjs.myblog.entity.MemberProfile;
import com.developerjs.myblog.repository.BlogRepository;
import com.developerjs.myblog.repository.MemberProfileRepository;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataSet;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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
    private final FileUtils fileUtils;

    public ResponseEntity<?> addBlog(BlogDto blogDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        String blogContent = convertMarkdownToHtml(blogDto.getBlogContent());
        Blog blog = Blog.builder()
                .blogTitle(blogDto.getBlogTitle())
                .blogContent(blogContent)
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

    public BlogDto getBlogDetail(Long id){
        Blog blog = blogRepository.getReferenceById(id);
        BlogDto blogDto = new BlogDto();
        Optional<MemberProfile> memberProfile = memberProfileRepository.findByMemberEmail(blog.getMemberEmail());
        if(memberProfile.isPresent()){
            MemberProfileDto memberProfileDto = new MemberProfileDto();
            memberProfileDto.setMemberName(memberProfile.get().getMemberName());
            memberProfileDto.setMemberDuty(memberProfile.get().getMemberDuty());
            memberProfileDto.setMemberCompanyName(memberProfile.get().getMemberCompanyName());
            memberProfileDto.setImageSourcePath(memberProfile.get().getImageSourcePath());
            memberProfileDto.setMemberBiography(memberProfile.get().getMemberBiography());
            blogDto.setMemberProfileDto(memberProfileDto);
        }
        blogDto.setId(blog.getId());
        blogDto.setBlogTitle(blog.getBlogTitle());
        blogDto.setBlogContent(blog.getBlogContent());
        blogDto.setBlogRegistTime(blog.getBlogRegistTime());

        return blogDto;
    }

    private String convertMarkdownToHtml(String markdown) {
        MutableDataSet options = new MutableDataSet();
        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        com.vladsch.flexmark.util.ast.Document document = parser.parse(markdown);
        String html = renderer.render(document);
        return html;
    }


    public ResponseEntity<?> addBlogImage(MultipartFile image) throws Exception {
        List<MultipartFile> files = new ArrayList<>();
        files.add(image);
        fileUtils.parseFileInfo(files);



        return ResponseEntity.ok("이미지 업로드 잘 되었습니다.");
    }
}
