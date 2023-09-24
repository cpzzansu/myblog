package com.developerjs.myblog.controller;

import com.developerjs.myblog.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.developerjs.myblog.dto.Member;

@AllArgsConstructor
@RestController
public class MemberController {

    private MemberService memberService;
    @PostMapping("/member")
    public void save(@RequestBody Member member){
        memberService.save(member);
    }

}
