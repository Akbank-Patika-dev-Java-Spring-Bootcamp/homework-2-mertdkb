package com.dikbiyik.ws.entity.user.dto;

import com.dikbiyik.ws.entity.user.AppUserType;

public record UpdateUserRequestDto(
        String username,
        String password,
        String phoneNumber,
        String email,
        AppUserType userType) {

}
