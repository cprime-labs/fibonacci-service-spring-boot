package com.cprime.fibonacciservice.apierror;

import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

public class ApiError {

    private HttpStatus status;
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;

    public HttpStatus getStatus() {
        return status;
    }
 
    private ApiError() {
        timestamp = LocalDateTime.now();
    }
 
    public ApiError(HttpStatus status) {
        this();
        this.status = status;
    }
 
    public ApiError(HttpStatus status, Throwable ex) {
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }
 
    public ApiError(HttpStatus status, String message, Throwable ex) {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }

}
