package com.dikbiyik.ws.entity.comment.dto;

import com.dikbiyik.ws.entity.product.Product;
import com.dikbiyik.ws.entity.user.User;

public record CommentPostDtoResponse(Long id,
        String commentBody,
        Product product,
        User user) {

}