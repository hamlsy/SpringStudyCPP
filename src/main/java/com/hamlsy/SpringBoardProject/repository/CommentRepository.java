package com.hamlsy.SpringBoardProject.repository;

import com.hamlsy.SpringBoardProject.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
