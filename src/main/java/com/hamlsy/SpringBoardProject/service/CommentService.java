package com.hamlsy.SpringBoardProject.service;

import com.hamlsy.SpringBoardProject.domain.Comment;
import com.hamlsy.SpringBoardProject.domain.Post;
import com.hamlsy.SpringBoardProject.repository.CommentRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    //post 가져오는 이유??
    //한 comment는 한 post에 소속
    public void create(Post post, String content){
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setPost(post);
        comment.setCreateDate(LocalDateTime.now());
        this.commentRepository.save(comment);
    }
}
