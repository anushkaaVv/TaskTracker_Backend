package com.TaskTracker.TaskTracker_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;



@RestControllerAdvice
public class GlobalExceptionHandler {
        @ExceptionHandler(ResourceNotFoundException.class)
        public String HandleResourceNotFoundException(ResourceNotFoundException ex){
            return ex.getMessage();
        }

       
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex)
        {
            Map<String,String> err=new HashMap<>();
            ex.getBindingResult().getFieldErrors().forEach(error->{err.put(error.getField(),error.getDefaultMessage());});
            return err;
        }

}
