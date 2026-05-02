package dev.felipegardin.events.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dev.felipegardin.events.dto.ErrorDTO;
import dev.felipegardin.events.exception.NotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {
    
    @ExceptionHandler(exception = NotFoundException.class)
    public ResponseEntity<ErrorDTO> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(404).body(new ErrorDTO(ex.getMessage()));
    }
}
