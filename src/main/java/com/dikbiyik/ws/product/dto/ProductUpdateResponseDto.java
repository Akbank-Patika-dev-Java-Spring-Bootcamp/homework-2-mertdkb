package com.dikbiyik.ws.product.dto;

import java.util.List;

import com.dikbiyik.ws.comment.dto.GetCommentDto;

public record ProductUpdateResponseDto(Long id,
        String productName,
        Integer price,
        List<GetCommentDto> comments) {

}
