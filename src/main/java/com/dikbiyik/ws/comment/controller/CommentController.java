package com.dikbiyik.ws.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dikbiyik.ws.comment.dto.CommentPostRequestDto;
import com.dikbiyik.ws.comment.service.CommentService;
import com.dikbiyik.ws.generic.rest.GenericApiResponse;

@RestController
@RequestMapping("/api/v1.0/comments")
public class CommentController {
    
    @Autowired
    private CommentService commentService;

    @PostMapping
    public GenericApiResponse postComment(@RequestBody CommentPostRequestDto dtoRequest){
        return new GenericApiResponse(200, "Success","136813511", commentService.postComment(dtoRequest));
    }

    @GetMapping("/{userid}/all")
    public GenericApiResponse getAllCommentsOfUser(@PathVariable Long userid){
        return new GenericApiResponse(200, "Success", "316843", commentService.getAllUserCommentsByUserId(userid));
    }

    @GetMapping("/{productid}")
    public GenericApiResponse getAllCommentsOfProduct(@PathVariable Long productid){
        return new GenericApiResponse(200, "Success", "6878943", commentService.getAllProductCommentsByProductId(productid));
    }
}
