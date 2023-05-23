package com.dikbiyik.ws.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor 
public class GenericErrorMessage {

    private LocalDateTime errorDate;
    private String message;
    private String detail;
}
