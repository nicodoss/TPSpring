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
        return new ResponseEntity<>(new ApiError(400,ex.getMessage()),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = {PersonneNotExistException.class })
    public ResponseEntity<ApiError>persNotfoundExcep(PersonneNotExistException ex){
        return new ResponseEntity<>(new ApiError(400,ex.getMessage()),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = {PaysNotFoundException.class })
    public ResponseEntity<ApiError>PaysNotFoundException(PaysNotFoundException ex){
        return new ResponseEntity<>(new ApiError(400,ex.getMessage()),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = {RowsVersionsChangingExceptions.class })
    public ResponseEntity<ApiError>RowsVersionsChangingExceptions(RowsVersionsChangingExceptions ex){
        return new ResponseEntity<>(new ApiError(409,ex.getMessage()),HttpStatus.CONFLICT);
    }
}
