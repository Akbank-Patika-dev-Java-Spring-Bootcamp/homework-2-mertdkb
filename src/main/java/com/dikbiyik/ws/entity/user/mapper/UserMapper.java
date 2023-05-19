package com.dikbiyik.ws.entity.user.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.dikbiyik.ws.entity.user.User;
import com.dikbiyik.ws.entity.user.dto.GetUserResponseDto;
import com.dikbiyik.ws.entity.user.dto.UpdateUserRequestDto;
import com.dikbiyik.ws.entity.user.dto.UpdateUserResponseDto;
import com.dikbiyik.ws.entity.user.dto.UserSaveRequestDto;
import com.dikbiyik.ws.entity.user.dto.UserSaveResponseDto;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userSaveRequestDtoToUser(UserSaveRequestDto userSaveDtoRequest);

    UserSaveResponseDto userToUserSaveDtoResponse(User user);

    GetUserResponseDto userToGetUserResponseDto(User user);

    List<GetUserResponseDto> usersToGetUserDtoResponses(List<User> users);

    User updateUserRequestDtoToUser(UpdateUserRequestDto updateUserRequestDto);

    UpdateUserResponseDto userToUpdateUserResponseDto(User user);
}
