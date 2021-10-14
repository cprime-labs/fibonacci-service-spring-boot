package com.cprime.fibonacciservice;

import com.cprime.fibonacciservice.apierror.*;
import com.cprime.fibonacciservice.exceptions.*;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.core.Ordered;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.WebRequest;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Malformed JSON request";
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
    }
 
    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(FibonacciIndexWrongTypeException.class)
    protected ResponseEntity<Object> handleIndexWrongType( FibonacciIndexWrongTypeException ex) {
       ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
       return buildResponseEntity(apiError);
    }

    @ExceptionHandler(FibonacciIndexOutOfBoundsException.class)
    protected ResponseEntity<Object> handleIndexOutOfBounds( FibonacciIndexOutOfBoundsException ex) {
       ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
       return buildResponseEntity(apiError);
    }
 
 }