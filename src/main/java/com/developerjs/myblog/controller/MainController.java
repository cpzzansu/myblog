package com.developerjs.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping({ "/" })
    public String redirect() {
        // 모든 요청을 Vue의 index.html로 전달
        return "forward:/index.html";
    }
}
