package com.dikbiyik.ws.exception.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@RequiredArgsConstructor
public class UserDataNotPairingException extends NullPointerException {
    
    private final String errorMessage;
    
}
