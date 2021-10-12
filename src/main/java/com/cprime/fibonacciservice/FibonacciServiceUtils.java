package com.cprime.fibonacciservice;

public class FibonacciServiceUtils {

    public static void validateInteger(String fibonacciIndex) throws FibonacciIndexWrongTypeException {
		try {
			Integer.parseInt(fibonacciIndex);
		} catch (NumberFormatException e) {
			throw new FibonacciIndexWrongTypeException("Index value must be an integer.");
		}
	}
    
}
