package com.Task.Task.Domain.DTO;

public record ErrorResponse(
        int status,
        String message,
        String details
) {
}
