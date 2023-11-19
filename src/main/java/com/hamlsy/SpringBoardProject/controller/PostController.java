package com.hamlsy.SpringBoardProject.controller;

import com.hamlsy.SpringBoardProject.domain.Post;
import com.hamlsy.SpringBoardProject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/post")
@RequiredArgsConstructor
@Controller
public class PostController {
    @Autowired
    private final PostService postService;
    //RequiredArgsConstructor에 의해 생성자 자동 생성
    @GetMapping("/list")
    public String list(Model model){
        List<Post> postList = this.postService.getList();
        //findAll method JPA에 의해 자동 생성 ->
        //findAll을 통해 postRepository에 있는 posts들 postList에 저장
        model.addAttribute("postList", postList);
        //모델 명, 반환 값
        return "post_list";
    }
    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        //getMapping의 {id} = @PathVariable("id")
        Post post = this.postService.getPost(id);
        model.addAttribute("post", post);
        return "post_detail";
    }
    @GetMapping("/create")
    public String postsCreate(){
        return "post_form";
    }
    @PostMapping("/create")
    public String postsCreate(@RequestParam String subject, @RequestParam String content){
        this.postService.create(subject, content);
        return "redirect:/post/list";
    }
}
