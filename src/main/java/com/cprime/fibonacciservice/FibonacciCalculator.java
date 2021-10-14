package com.cprime.fibonacciservice;

import com.cprime.fibonacciservice.exceptions.*;
import com.cprime.fibonacciservice.utils.FibonacciServiceUtils;

public class FibonacciCalculator {

	public static FibonacciNumber calculateFiboacciNumberByIndex(int fibonacciIndex) throws FibonacciIndexOutOfBoundsException {

		FibonacciServiceUtils.validateIntegerIndexBounds(fibonacciIndex);

		FibonacciNumber fibonacciNumber = new FibonacciNumber();

		if (fibonacciIndex <= 1) {
			fibonacciNumber.setFibonacciValue(fibonacciIndex);
			fibonacciNumber.setFibonacciIndex(fibonacciIndex);
			return fibonacciNumber;
		}

		long[] fibNums = new long[fibonacciIndex + 1];
		fibNums[0] = 0;
		fibNums[1] = 1;
		for (int index = 2; index <= fibonacciIndex; index++) {
			fibNums[index] = fibNums[index - 1] + fibNums[index - 2];
		}

		fibonacciNumber.setFibonacciValue(fibNums[fibonacciIndex]);
		fibonacciNumber.setFibonacciIndex(fibonacciIndex);

		return fibonacciNumber;

	}

}
