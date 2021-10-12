package com.cprime.fibonacciservice;

public class FibonacciServiceUtils {

    public static void validateInteger(String fibonacciIndex) throws FibonacciIndexWrongTypeException {
		try {
			Integer.parseInt(fibonacciIndex);
		} catch (NumberFormatException e) {
			throw new FibonacciIndexWrongTypeException("Index value must be an integer.");
		}
	}

    public static void validateIntegerIndexBounds(int fibonacciIndex) throws FibonacciIndexOutOfBoundsException {
		
        if(fibonacciIndex < 0 || fibonacciIndex > 75) {
			throw new FibonacciIndexOutOfBoundsException("The minimum index this service can calculate a Fibonacci number for is '0' and maximum index this service can calculate a Fibonacci number for is '75'");
		}
	}
    
}
