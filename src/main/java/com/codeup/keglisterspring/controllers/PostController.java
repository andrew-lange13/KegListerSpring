package com.codeup.keglisterspring.controllers;

import com.codeup.keglisterspring.models.Post;
import com.codeup.keglisterspring.models.User;
import com.codeup.keglisterspring.repositories.PostRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/")
    public String posts(Model model){
        model.addAttribute("post", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/create")
    public String createPostGet(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/create")
    public String createPost(@Valid Post post, Errors validation, Model model){
        if (validation.hasErrors()){
            model.addAttribute("errors", validation);
            model.addAttribute("post", post);
            return "posts/create";
        }
        post.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        postDao.save(post);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String getPost(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.getById(id));
        return "/posts/edit";
    }

    @PostMapping("/{id}/edit")
    public String editPost(@Valid@ModelAttribute Post post, Errors validation, Model model){
        if (validation.hasErrors()){
            model.addAttribute("errors", validation);
            model.addAttribute("post", post);
            return "/posts/edit";
        }
        post.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "redirect:/";
    }
}
