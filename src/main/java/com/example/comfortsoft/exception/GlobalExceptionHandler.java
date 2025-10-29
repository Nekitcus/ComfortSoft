package com.example.comfortsoft.exception;

import com.example.comfortsoft.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleApi(ApiException ex) {
        log.warn("Business error: {}", ex.getMessage());
        return ResponseEntity.badRequest().body(
                ErrorResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .error(ex.getMessage())
                        .build()
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnexpected(Exception ex) {
        log.error("Unexpected error: ", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ErrorResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .error("Internal server error")
                        .details(ex.getMessage())
                        .build()
        );
    }
}
