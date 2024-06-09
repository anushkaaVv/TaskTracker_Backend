package com.TaskTracker.TaskTracker_backend.exception;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
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
            Map<String,String> errors=new HashMap<>();
            ex.getBindingResult().getFieldErrors().forEach(error->{errors.put(error.getField(),error.getDefaultMessage());});
            return errors;
        }


        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(HttpMessageNotReadableException.class)
        public ResponseEntity<String> handleInvalidInput(HttpMessageNotReadableException e) {
            return ResponseEntity.badRequest().body("Status should be either Done or Pending");
        }


}
