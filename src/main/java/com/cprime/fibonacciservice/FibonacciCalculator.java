package com.cprime.fibonacciservice;

public class FibonacciCalculator {

	public static FibonacciNumber calculateFiboacciNumberByIndex(int fibonacciIndex) throws FibonacciIndexOutOfBoundsException {

		if(fibonacciIndex < 0 || fibonacciIndex > 75) {
			throw new FibonacciIndexOutOfBoundsException("The minimum index this service can calculate a Fibonacci number for is '0' and maximum index this service can calculate a Fibonacci number for is '75'");
		}

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
