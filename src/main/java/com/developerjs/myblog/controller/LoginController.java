package com.developerjs.myblog.controller;

import com.developerjs.myblog.dto.LoginAccessTokenResponse;
import com.developerjs.myblog.dto.Member;
import com.developerjs.myblog.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://144.24.73.164:8088")
public class LoginController {

    private AuthenticationService authenticationService;
    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody Member member){
        try{
            System.out.println("hi");
            LoginAccessTokenResponse loginAccessTokenResponse =
                    authenticationService.authenticateMember(member.getMemberEmail(), member.getMemberPw());
            return ResponseEntity.ok(loginAccessTokenResponse);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

}
