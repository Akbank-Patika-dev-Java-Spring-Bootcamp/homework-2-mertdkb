package com.dikbiyik.ws.user.dto;

import java.util.List;

import com.dikbiyik.ws.comment.dto.GetCommentDto;
import com.dikbiyik.ws.user.AppUserType;

public record GetUserResponseDto( Long id,
String username,
String password,
String phoneNumber,
String email,
AppUserType userType,
List<GetCommentDto> comments) {
       

}
