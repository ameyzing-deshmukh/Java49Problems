package org.problems.microservices.exceptionhandling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleNotFoundExc(ResourceNotFoundException ex) {
        return new ResponseEntity<>(Map.of(
                "timestamp", LocalDateTime.now(),
                "message", ex.getMessage(),
                "status", HttpStatus.NOT_FOUND.value()
        ), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequest(BadRequestException ex) {
        return new ResponseEntity<>(Map.of(
                "timestamp", LocalDateTime.now(),
                "message", ex.getMessage(),
                "status", HttpStatus.BAD_REQUEST.value()
        ), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneralException(Exception ex) {
        return new ResponseEntity<>(Map.of(
                "timestamp", LocalDateTime.now(),
                "message", ex.getMessage(),
                "status", HttpStatus.INTERNAL_SERVER_ERROR
        ), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
