package com.dikbiyik.ws.comment.dto;


public record CommentPostRequestDto(
        String commentBody,
        Long productId,
        Long userId) {

}
