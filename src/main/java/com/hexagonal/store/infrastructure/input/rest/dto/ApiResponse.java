package com.hexagonal.store.infrastructure.input.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse<T>(
    T data,
    String message,
    LocalDateTime timestamp,
    String path
) {
    public static <T> ApiResponse<T> success(T data, String path) {
        return new ApiResponse<>(data, null, LocalDateTime.now(), path);
    }

    public static <T> ApiResponse<T> error(String message, String path) {
        return new ApiResponse<>(null, message, LocalDateTime.now(), path);
    }
}
