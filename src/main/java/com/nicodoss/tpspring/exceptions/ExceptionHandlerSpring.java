package com.nicodoss.tpspring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerSpring extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = { CompteClientNotExistException.class })
   public ResponseEntity<ApiError>clientNotfoundExcep(CompteClientNotExistException ex){
        return new ResponseEntity<>(new ApiError(400,ex.getMessage()), HttpStatus.NOT_FOUND);

    }

}
