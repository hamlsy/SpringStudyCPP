package com.hamlsy.SpringBoardProject.controller;

import com.hamlsy.SpringBoardProject.domain.Comment;
import com.hamlsy.SpringBoardProject.domain.Post;
import com.hamlsy.SpringBoardProject.repository.CommentRepository;
import com.hamlsy.SpringBoardProject.repository.PostRepository;
import com.hamlsy.SpringBoardProject.service.CommentService;
import com.hamlsy.SpringBoardProject.service.PostService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
@RequestMapping("/comment")
public class CommentController {
    //Autowired 안붙는 이유, final 붙은 이유

    private final PostService postService;
    private final CommentService commentService;

    @PostMapping("/create/{id}")
    public String createComment(Model model, @PathVariable("id") Integer id, @RequestParam String content) {
        //this로 선언
        Post post = this.postService.getPost(id);
        this.commentService.create(post, content);
        return String.format("redirect:/post/detail/%s", id);
    }
}
