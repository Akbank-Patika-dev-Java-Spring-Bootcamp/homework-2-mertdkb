package com.dikbiyik.ws.entity.comment.dto;


public record CommentPostDtoRequest(
        String commentBody,
        Long productId,
        Long userId) {

}
