package com.codeup.keglisterspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdController {

    @GetMapping("/")
    public String posts(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }
}
