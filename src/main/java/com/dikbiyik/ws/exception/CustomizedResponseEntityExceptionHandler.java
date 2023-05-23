package com.dikbiyik.ws.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dikbiyik.ws.exception.comment.ThereIsNoCommentOnProductException;
import com.dikbiyik.ws.exception.comment.ThereIsNoCommentOnUserException;
import com.dikbiyik.ws.exception.user.UserDataNotPairingException;


@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<GenericErrorMessage> handleUserDataNotPairingException(UserDataNotPairingException e, WebRequest webRequest){

        String message = e.getErrorMessage();
        String description = webRequest.getDescription(false);
        var errorMessage = new GenericErrorMessage(LocalDateTime.now(), message, description);
        var response = ResponseEntity.internalServerError().body(errorMessage);

        return response;
    }

    @ExceptionHandler
    public final ResponseEntity<GenericErrorMessage> handleNoCommentOnUser(ThereIsNoCommentOnUserException e, WebRequest webRequest){

        String message = e.getErrorMessage();
        String description = webRequest.getDescription(false);
        var errorMessage = new GenericErrorMessage(LocalDateTime.now(), message, description);
        var response = ResponseEntity.internalServerError().body(errorMessage);

        return response;
    }

    @ExceptionHandler
    public final ResponseEntity<GenericErrorMessage> handleNoCommentOnProduct(ThereIsNoCommentOnProductException e, WebRequest webRequest){

        String message = e.getErrorMessage();
        String description = webRequest.getDescription(false);
        var errorMessage = new GenericErrorMessage(LocalDateTime.now(), message, description);
        var response = ResponseEntity.internalServerError().body(errorMessage);

        return response;
    }


}
