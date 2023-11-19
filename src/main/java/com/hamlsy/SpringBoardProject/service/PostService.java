package com.hamlsy.SpringBoardProject.service;

import com.hamlsy.SpringBoardProject.DataNotFoundException;
import com.hamlsy.SpringBoardProject.domain.Post;
import com.hamlsy.SpringBoardProject.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {
    //repository가 늘어날 경우 여러 controller의 중복 기능 코드가 늘어나므로 Service class 작성

    private final PostRepository postRepository;
    public List<Post> getList(){
        return this.postRepository.findAll();
    }
    //id 값으로 posts 데이터 조회
    public Post getPost(Integer id){
        //posts 객체 = optional 객체
        Optional<Post> post = this.postRepository.findById(id);
        if(post.isPresent()){
            return post.get();
        }else{
            throw new DataNotFoundException("post not found");
        }

    }
    public void create(String subject, String content){
        Post p = new Post();
        p.setSubject(subject);
        p.setContent(content);
        p.setCreateDate(LocalDateTime.now());
        this.postRepository.save(p);
    }
}
