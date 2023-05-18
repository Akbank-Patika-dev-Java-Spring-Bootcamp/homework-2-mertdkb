package com.dikbiyik.ws.entity.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dikbiyik.ws.entity.comment.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    
}
