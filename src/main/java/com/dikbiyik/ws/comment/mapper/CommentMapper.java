package com.dikbiyik.ws.comment.mapper;


import java.util.List;

import org.mapstruct.Mapper;

import com.dikbiyik.ws.comment.Comment;
import com.dikbiyik.ws.comment.dto.CommentGetResponseDto;
import com.dikbiyik.ws.comment.dto.CommentPostRequestDto;
import com.dikbiyik.ws.comment.dto.CommentPostResponseDto;


@Mapper(componentModel = "spring")
public interface CommentMapper {
    
    Comment commentPostDtoRequestToComment(CommentPostRequestDto postDtoRequest);

    CommentPostResponseDto commentToCommentPostDtoResponse(Comment comment);

    CommentGetResponseDto commentToCommentGetResponseDto(Comment findByIdWithControl);

    List<CommentGetResponseDto> commentsToCommentGetResponseDtos(List<Comment> comments);
}
