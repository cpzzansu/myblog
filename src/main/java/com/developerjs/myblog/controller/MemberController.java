package com.developerjs.myblog.controller;

import com.developerjs.myblog.common.FileUtils;
import com.developerjs.myblog.dto.FileDto;
import com.developerjs.myblog.dto.MemberProfileDto;
import com.developerjs.myblog.entity.MemberProfile;
import com.developerjs.myblog.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.developerjs.myblog.dto.Member;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
public class MemberController {

    private MemberService memberService;
    private FileUtils fileUtils;
    @PostMapping("/member")
    public void save(@RequestBody Member member){
        memberService.save(member);
    }

    @PostMapping("/private/profile")
    public ResponseEntity<?> modifyProfile(@RequestParam("memberEmail") String memberEmail,
                                      @RequestParam("memberName") String memberName,
                                      @RequestParam("memberPhone") String memberPhone,
                                      @RequestParam("memberCompanyName") String memberCompanyName,
                                      @RequestParam("memberDuty") String memberDuty,
                                      @RequestParam("memberBiography") String memberBiography,
                                      @RequestParam(name = "memberProfilePicture", required = false) MultipartFile memberProfilePicture) throws Exception {
        MemberProfileDto memberProfileDto = new MemberProfileDto();
        memberProfileDto.setMemberEmail(memberEmail);
        memberProfileDto.setMemberName(memberName);
        memberProfileDto.setMemberPhone(memberPhone);
        memberProfileDto.setMemberCompanyName(memberCompanyName);
        memberProfileDto.setMemberDuty(memberDuty);
        memberProfileDto.setMemberBiography(memberBiography);

        return memberService.modifyMemberProfile(memberProfileDto, memberEmail, memberProfilePicture);
    }

    @GetMapping("/private/profile")
    public MemberProfileDto getProfile(){
        // SecurityContext에서 Authentication 객체 가져오기
        System.out.println("여기야");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());
        // Authentication 객체에서 principal 가져오기 (여기서는 userId)
        String userEmail = authentication.getName();
        return memberService.getProfile(userEmail);
    }

    @GetMapping("/private/resource")
    public ResponseEntity<?> auth(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
