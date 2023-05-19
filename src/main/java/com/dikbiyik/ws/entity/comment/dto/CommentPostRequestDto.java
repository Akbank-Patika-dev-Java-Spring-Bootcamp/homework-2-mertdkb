package com.dikbiyik.ws.entity.comment.dto;


public record CommentPostRequestDto(
        String commentBody,
        Long productId,
        Long userId) {

}
