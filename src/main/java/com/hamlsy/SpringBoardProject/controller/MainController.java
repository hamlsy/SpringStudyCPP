package com.hamlsy.SpringBoardProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String root(){
        return "redirect:/post/list";
        //posts/list url로 redirect
    }
}
