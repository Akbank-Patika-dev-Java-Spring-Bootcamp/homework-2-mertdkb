package com.dikbiyik.ws.user.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.dikbiyik.ws.user.User;
import com.dikbiyik.ws.user.dto.GetUserResponseDto;
import com.dikbiyik.ws.user.dto.UpdateUserRequestDto;
import com.dikbiyik.ws.user.dto.UpdateUserResponseDto;
import com.dikbiyik.ws.user.dto.UserSaveRequestDto;
import com.dikbiyik.ws.user.dto.UserSaveResponseDto;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userSaveRequestDtoToUser(UserSaveRequestDto userSaveDtoRequest);

    UserSaveResponseDto userToUserSaveDtoResponse(User user);

    GetUserResponseDto userToGetUserResponseDto(User user);

    List<GetUserResponseDto> usersToGetUserDtoResponses(List<User> users);

    User updateUserRequestDtoToUser(UpdateUserRequestDto updateUserRequestDto);

    UpdateUserResponseDto userToUpdateUserResponseDto(User user);
}
