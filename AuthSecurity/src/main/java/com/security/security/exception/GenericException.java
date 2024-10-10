package com.security.security.exception;

import org.springframework.http.HttpStatus;

public class GenericException extends RuntimeException {

    private HttpStatus status;
    private String message;
    private String details;

    public GenericException(HttpStatus status, String message, String details) {
        super(message);
        this.status = status;
        this.message = message;
        this.details = details;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
