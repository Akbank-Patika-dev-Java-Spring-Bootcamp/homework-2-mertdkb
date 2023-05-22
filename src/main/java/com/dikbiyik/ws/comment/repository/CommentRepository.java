package com.dikbiyik.ws.comment.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dikbiyik.ws.comment.Comment;


public interface CommentRepository extends JpaRepository<Comment, Long>{
    
}
