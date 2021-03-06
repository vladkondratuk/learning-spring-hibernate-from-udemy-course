package com.spring.mvc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    @ResponseBody
    @GetMapping("/hello")
    public String welcome() {
        return "hello";
    }

    @GetMapping("/")
    public String showPage() {
        return "main-menu";
    }
}
