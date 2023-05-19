package com.dikbiyik.ws.entity.comment.dto;

import com.dikbiyik.ws.entity.product.dto.ProductGetDto;
import com.dikbiyik.ws.entity.user.dto.UserGetDto;

public record CommentGetResponseDto(Long id,
        String commentBody,
        ProductGetDto product,
        UserGetDto user) {

}
