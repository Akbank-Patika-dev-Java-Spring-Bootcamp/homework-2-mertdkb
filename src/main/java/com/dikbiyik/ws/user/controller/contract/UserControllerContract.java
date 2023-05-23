package com.dikbiyik.ws.user.controller.contract;


import java.util.List;

import com.dikbiyik.ws.user.dto.DeleteUserRequestDto;
import com.dikbiyik.ws.user.dto.GetUserResponseDto;
import com.dikbiyik.ws.user.dto.UpdateUserRequestDto;
import com.dikbiyik.ws.user.dto.UpdateUserResponseDto;
import com.dikbiyik.ws.user.dto.UserSaveRequestDto;
import com.dikbiyik.ws.user.dto.UserSaveResponseDto;

public interface UserControllerContract {
    UserSaveResponseDto saveUser(UserSaveRequestDto userSaveDtoRequest);

    List<GetUserResponseDto> getAllUsers();

    GetUserResponseDto getUserById(Long id);

    GetUserResponseDto getUserByUsername(String username);

    UpdateUserResponseDto updateUser(Long id, UpdateUserRequestDto updateUserRequestDto);

    void deleteUser(DeleteUserRequestDto deleteUserRequestDto);
}
