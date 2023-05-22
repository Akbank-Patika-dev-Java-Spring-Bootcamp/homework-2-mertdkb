package com.dikbiyik.ws.user.dto;

import com.dikbiyik.ws.user.AppUserType;

public record UserSaveResponseDto(
        Long id,
        String username,
        String phoneNumber,
        String email,
        AppUserType userType) {

}
