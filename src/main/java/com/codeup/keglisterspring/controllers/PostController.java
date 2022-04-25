package com.codeup.keglisterspring.controllers;

import com.codeup.keglisterspring.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/")
    public String posts(Model model){
        model.addAttribute("ad", postDao.findAll());
        return "posts/index";
    }
}
