package com.dikbiyik.ws.entity.user.dto;

import com.dikbiyik.ws.entity.user.AppUserType;

public record UserSaveResponseDto(
        Long id,
        String username,
        String phoneNumber,
        String email,
        AppUserType userType) {

}
