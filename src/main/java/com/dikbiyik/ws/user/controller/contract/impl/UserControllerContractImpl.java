package com.dikbiyik.ws.user.controller.contract.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dikbiyik.ws.user.User;
import com.dikbiyik.ws.user.controller.contract.UserControllerContract;
import com.dikbiyik.ws.user.dto.DeleteUserRequestDto;
import com.dikbiyik.ws.user.dto.GetUserResponseDto;
import com.dikbiyik.ws.user.dto.UpdateUserRequestDto;
import com.dikbiyik.ws.user.dto.UpdateUserResponseDto;
import com.dikbiyik.ws.user.dto.UserSaveRequestDto;
import com.dikbiyik.ws.user.dto.UserSaveResponseDto;
import com.dikbiyik.ws.user.mapper.UserMapper;
import com.dikbiyik.ws.user.service.AppUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserControllerContractImpl implements UserControllerContract {

    private final AppUserService appUserService;

    private final UserMapper userMapper;

    @Override
    public UserSaveResponseDto saveUser(UserSaveRequestDto userSaveDtoRequest) {
        User user = userMapper.userSaveRequestDtoToUser(userSaveDtoRequest);
        appUserService.save(user);
        UserSaveResponseDto responseDto = userMapper.userToUserSaveDtoResponse(user);
        return responseDto;
    }

    @Override
    public List<GetUserResponseDto> getAllUsers() {
        return userMapper.usersToGetUserDtoResponses(appUserService.findAll());
    }

    @Override
    public GetUserResponseDto getUserById(Long id) {
        return userMapper.userToGetUserResponseDto(appUserService.findByIdWithControl(id));
    }

    @Override
    public GetUserResponseDto getUserByUsername(String username) {
        return userMapper.userToGetUserResponseDto(appUserService.findByUsername(username));
    }

    @Override
    public UpdateUserResponseDto updateUser(Long id, UpdateUserRequestDto updateUserRequestDto) {
        User user = appUserService.updateUser(id, userMapper.updateUserRequestDtoToUser(updateUserRequestDto));
        return userMapper.userToUpdateUserResponseDto(user);
    }

    @Override
    public void deleteUser(DeleteUserRequestDto deleteUserRequestDto) {
        User userInDb = appUserService.findByUsernameAndPhoneNumber(deleteUserRequestDto.username(), deleteUserRequestDto.phoneNumber());
        appUserService.delete(userInDb);
    }

}
