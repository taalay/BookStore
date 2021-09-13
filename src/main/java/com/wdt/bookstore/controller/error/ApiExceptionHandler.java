package com.wdt.bookstore.controller.error;

import com.wdt.bookstore.exceptions.AuthorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<AprErrorResponse> handleException(Exception ex){
        AprErrorResponse errorResponse = AprErrorResponse.builder().message(ex.getMessage()).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {AuthorNotFoundException.class})
    public ResponseEntity<AprErrorResponse> handleNotFoundException(AuthorNotFoundException ex){
        AprErrorResponse errorResponse = AprErrorResponse.builder().message(ex.getMessage()).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
