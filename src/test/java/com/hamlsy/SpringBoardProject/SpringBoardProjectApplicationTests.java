package com.hamlsy.SpringBoardProject;

import com.hamlsy.SpringBoardProject.domain.Post;
import com.hamlsy.SpringBoardProject.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class SpringBoardProjectApplicationTests {
	@Autowired
	private PostRepository postRepository;
	@Test
	void testJpa(){
		Post p = new Post();
		p.setSubject("test subject 1");
		p.setContent("test content 1");
		p.setCreateDate(LocalDateTime.now());
		this.postRepository.save(p);
	}

}
