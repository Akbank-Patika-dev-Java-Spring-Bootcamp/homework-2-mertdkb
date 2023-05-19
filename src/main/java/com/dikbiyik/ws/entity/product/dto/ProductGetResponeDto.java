package com.dikbiyik.ws.entity.product.dto;

import java.util.List;

import com.dikbiyik.ws.entity.comment.dto.GetCommentDto;

public record ProductGetResponeDto(Long id,
        String productName,
        Integer price,
        List<GetCommentDto> comments) {

}
