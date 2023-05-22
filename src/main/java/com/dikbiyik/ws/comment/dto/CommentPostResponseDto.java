package com.dikbiyik.ws.comment.dto;

import com.dikbiyik.ws.product.Product;
import com.dikbiyik.ws.user.User;

public record CommentPostResponseDto(Long id,
        String commentBody,
        Product product,
        User user) {

}
