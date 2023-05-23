package com.dikbiyik.ws.comment.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dikbiyik.ws.comment.controller.contract.CommentControllerContract;
import com.dikbiyik.ws.comment.dto.CommentGetResponseDto;
import com.dikbiyik.ws.comment.dto.CommentPostRequestDto;
import com.dikbiyik.ws.comment.dto.CommentPostResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1.0/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentControllerContract commentControllerContract;

    @PostMapping
    public ResponseEntity<CommentPostResponseDto> postComment(@RequestBody CommentPostRequestDto dtoRequest){
        CommentPostResponseDto response = commentControllerContract.postComment(dtoRequest);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{userid}/all")
    public ResponseEntity<List<CommentGetResponseDto>> getAllCommentsOfUser(@PathVariable Long userid){
        List<CommentGetResponseDto> response = commentControllerContract.getAllCommentsOfUser(userid);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{productid}")
    public ResponseEntity<List<CommentGetResponseDto>> getAllCommentsOfProduct(@PathVariable Long productid){
        List<CommentGetResponseDto> response = commentControllerContract.getAllCommentsOfProduct(productid);
        return ResponseEntity.ok().body(response);
    }
}
