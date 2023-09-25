package com.developerjs.myblog.controller;

import com.developerjs.myblog.dto.Member;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class LoginController {

    @PostMapping("/login")
    public void save(@RequestBody Member member){

    }

}
