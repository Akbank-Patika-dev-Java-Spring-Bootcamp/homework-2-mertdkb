package com.dikbiyik.ws.comment.controller.contract.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dikbiyik.ws.comment.Comment;
import com.dikbiyik.ws.comment.controller.contract.CommentControllerContract;
import com.dikbiyik.ws.comment.dto.CommentGetResponseDto;
import com.dikbiyik.ws.comment.dto.CommentPostRequestDto;
import com.dikbiyik.ws.comment.dto.CommentPostResponseDto;
import com.dikbiyik.ws.comment.mapper.CommentMapper;
import com.dikbiyik.ws.comment.service.CommentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentControllerContractImpl implements CommentControllerContract {

    private final CommentService commentService;

    private final CommentMapper commentMapper;

    @Override
    public CommentPostResponseDto postComment(CommentPostRequestDto requestDto) {
        Comment response = commentService.saveComment(requestDto);
        return commentMapper.commentToCommentPostDtoResponse(response);
    }

    @Override
    public List<CommentGetResponseDto> getAllCommentsOfUser(Long userid) {
        List<Comment> response = commentService.getAllUserCommentsByUserId(userid);
        return commentMapper.commentsToCommentGetResponseDtos(response);
    }

    @Override
    public List<CommentGetResponseDto> getAllCommentsOfProduct(Long productid) {
        List<Comment> response = commentService.getAllProductCommentsByProductId(productid);
        return commentMapper.commentsToCommentGetResponseDtos(response);
    }
    
}
