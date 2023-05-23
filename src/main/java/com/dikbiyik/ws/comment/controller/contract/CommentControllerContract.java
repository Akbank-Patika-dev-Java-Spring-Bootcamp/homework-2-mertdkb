package com.dikbiyik.ws.comment.controller.contract;

import java.util.List;

import com.dikbiyik.ws.comment.dto.CommentGetResponseDto;
import com.dikbiyik.ws.comment.dto.CommentPostRequestDto;
import com.dikbiyik.ws.comment.dto.CommentPostResponseDto;

public interface CommentControllerContract {
    
    CommentPostResponseDto postComment(CommentPostRequestDto requestDto);

    List<CommentGetResponseDto> getAllCommentsOfUser(Long userid);

    List<CommentGetResponseDto> getAllCommentsOfProduct(Long productid);

    void deleteComment(Long id);
}
