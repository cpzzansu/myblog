package com.developerjs.myblog.controller;

import com.developerjs.myblog.dto.LoginAccessTokenResponse;
import com.developerjs.myblog.dto.Member;
import com.developerjs.myblog.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class LoginController {

    private AuthenticationService authenticationService;
    @PostMapping("/login")
    public ResponseEntity<?> save(@RequestBody Member member){
        try{
            LoginAccessTokenResponse loginAccessTokenResponse =
                    authenticationService.authenticateMember(member.getMemberEmail(), member.getMemberPw());
            return ResponseEntity.ok(loginAccessTokenResponse);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

}
