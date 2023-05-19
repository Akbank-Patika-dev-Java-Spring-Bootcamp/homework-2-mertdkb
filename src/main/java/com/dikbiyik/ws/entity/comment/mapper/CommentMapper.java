package com.dikbiyik.ws.entity.comment.mapper;

import org.mapstruct.Mapper;

import com.dikbiyik.ws.entity.comment.Comment;
import com.dikbiyik.ws.entity.comment.dto.CommentPostDtoRequest;
import com.dikbiyik.ws.entity.comment.dto.CommentPostDtoResponse;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    
    Comment commentPostDtoRequestToComment(CommentPostDtoRequest postDtoRequest);

    CommentPostDtoResponse commentToCommentPostDtoResponse(Comment comment);
}
