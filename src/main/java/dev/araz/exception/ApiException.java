package dev.araz.exception;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class ApiException {
    private final String message;
    private final Throwable throwable;
    private final ZonedDateTime timestamp;
}