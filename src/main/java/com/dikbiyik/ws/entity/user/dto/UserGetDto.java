package com.dikbiyik.ws.entity.user.dto;

import com.dikbiyik.ws.entity.user.AppUserType;

public record UserGetDto(Long id,
        String username,
        String password,
        String phoneNumber,
        String email,
        AppUserType userType) {

}
