package com.User_Service.User_Service.exception;

import com.User_Service.User_Service.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(ResourceNotFoundExp.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundExp exp) {
        String message = exp.getMessage();

        ApiResponse response = new ApiResponse.Builder()
                .message(message)
                .success(false) // Typically, exceptions indicate failure
                .status(HttpStatus.NOT_FOUND)
                .build();

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
