package com.dikbiyik.ws.user.dto;

import com.dikbiyik.ws.user.AppUserType;

public record UpdateUserRequestDto(
        String username,
        String password,
        String phoneNumber,
        String email,
        AppUserType userType) {

}
