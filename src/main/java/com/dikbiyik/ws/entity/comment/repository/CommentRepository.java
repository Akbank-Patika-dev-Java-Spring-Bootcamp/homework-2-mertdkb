package com.dikbiyik.ws.entity.comment.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dikbiyik.ws.entity.comment.Comment;


public interface CommentRepository extends JpaRepository<Comment, Long>{
    
}
