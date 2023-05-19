package com.dikbiyik.ws.entity.user.dto;

import java.util.List;

import com.dikbiyik.ws.entity.comment.dto.GetCommentDto;
import com.dikbiyik.ws.entity.user.AppUserType;

public record GetUserResponseDto( Long id,
String username,
String password,
String phoneNumber,
String email,
AppUserType userType,
List<GetCommentDto> comments) {
       

}
