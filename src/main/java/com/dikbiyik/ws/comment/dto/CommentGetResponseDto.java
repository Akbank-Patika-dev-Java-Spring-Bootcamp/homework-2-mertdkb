package com.dikbiyik.ws.comment.dto;

import com.dikbiyik.ws.product.dto.ProductGetDto;
import com.dikbiyik.ws.user.dto.UserGetDto;

public record CommentGetResponseDto(Long id,
        String commentBody,
        ProductGetDto product,
        UserGetDto user) {

}
