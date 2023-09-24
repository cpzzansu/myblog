package com.developerjs.myblog.controller;

import com.developerjs.myblog.dto.Member;
import com.developerjs.myblog.service.AuthenticationService;
import com.developerjs.myblog.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class LoginController {

    private AuthenticationService authService;
    @PostMapping("/member")
    public void save(@RequestBody Member member){

    }

}
