package com.cprime.fibonacciservice.utils;

import com.cprime.fibonacciservice.exceptions.*;

public class FibonacciServiceUtils {

    public static void validateInteger(String fibonacciIndex) throws FibonacciIndexWrongTypeException {
		try {
			Integer.parseInt(fibonacciIndex);
		} catch (NumberFormatException e) {
			throw new FibonacciIndexWrongTypeException();
		}
	}

    public static void validateIntegerIndexBounds(int fibonacciIndex) throws FibonacciIndexOutOfBoundsException {
		
        if(fibonacciIndex < 0 || fibonacciIndex > 75) {
			throw new FibonacciIndexOutOfBoundsException();
		}
	}
    
}
