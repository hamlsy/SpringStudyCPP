package com.hamlsy.SpringBoardProject.repository;

import com.hamlsy.SpringBoardProject.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
//JpaRepository 상속할 때 엔티티의 타입 Posts, PK의 속성타입 Int 지정
public interface PostRepository extends JpaRepository<Post, Integer> {
}
