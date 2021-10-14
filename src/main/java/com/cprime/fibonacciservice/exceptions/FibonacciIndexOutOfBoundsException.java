package com.cprime.fibonacciservice.exceptions;

public class FibonacciIndexOutOfBoundsException extends Exception {

    public FibonacciIndexOutOfBoundsException() {
        super("The minimum index this service can calculate a Fibonacci number for is '0' and maximum index this service can calculate a Fibonacci number for is '75'");
    }

}
