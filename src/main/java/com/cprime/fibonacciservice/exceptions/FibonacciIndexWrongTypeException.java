package com.cprime.fibonacciservice.exceptions;

public class FibonacciIndexWrongTypeException extends Exception {

    public FibonacciIndexWrongTypeException() {
        super("Index value must be an integer.");
    }

}
