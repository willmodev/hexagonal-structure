package com.hexagonal.store.infrastructure.exception;

import com.hexagonal.store.domain.exception.ProductNotFoundException;
import com.hexagonal.store.infrastructure.input.rest.dto.ApiResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleProductNotFoundException(
            ProductNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(
            ApiResponse.error(ex.getMessage(), request.getDescription(false)),
            HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleValidationExceptions(
            MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        
        return new ResponseEntity<>(
            new ApiResponse<>(
                errors,
                "Error de validación",
                java.time.LocalDateTime.now(),
                request.getDescription(false)
            ),
            HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse<Void>> handleConstraintViolationException(
            ConstraintViolationException ex, WebRequest request) {
        return new ResponseEntity<>(
            ApiResponse.error(ex.getMessage(), request.getDescription(false)),
            HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleAllUncaughtException(
            Exception ex, WebRequest request) {
        return new ResponseEntity<>(
            ApiResponse.error(
                "Ocurrió un error interno en el servidor",
                request.getDescription(false)
            ),
            HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
