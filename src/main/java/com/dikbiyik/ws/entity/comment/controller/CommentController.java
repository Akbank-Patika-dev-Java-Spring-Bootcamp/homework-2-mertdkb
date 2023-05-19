package com.dikbiyik.ws.entity.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dikbiyik.ws.entity.comment.dto.CommentPostDtoRequest;
import com.dikbiyik.ws.entity.comment.service.CommentService;
import com.dikbiyik.ws.generic.rest.GenericApiResponse;

@RestController
@RequestMapping("/api/v1.0/comments")
public class CommentController {
    
    @Autowired
    private CommentService commentService;

    @PostMapping
    public GenericApiResponse postComment(@RequestBody CommentPostDtoRequest dtoRequest){
        return new GenericApiResponse(200, "Success","136813511", commentService.postComment(dtoRequest));
    }
}
