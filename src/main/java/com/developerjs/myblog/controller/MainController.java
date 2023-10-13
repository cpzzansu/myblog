package com.developerjs.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "http://144.24.73.164:8088")
public class MainController {

    @RequestMapping({ "/" })
    public String redirect() {
        // 모든 요청을 Vue의 index.html로 전달
        return "forward:/index.html";
    }
}
