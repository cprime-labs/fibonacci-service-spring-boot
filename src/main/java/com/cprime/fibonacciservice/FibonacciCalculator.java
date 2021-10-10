package com.cprime.fibonacciservice;

public class FibonacciCalculator {

	public static FibonacciNumber calculateFiboacciNumberByIndex(int fibonacciIndex) {

		FibonacciNumber fibonacciNumber = new FibonacciNumber();

		if (fibonacciIndex <= 1) {
			fibonacciNumber.setFibValue(fibonacciIndex);
			fibonacciNumber.setIndex(fibonacciIndex);
			return fibonacciNumber;
		}

		int[] fibNums = new int[fibonacciIndex + 1];
		fibNums[0] = 0;
		fibNums[1] = 1;
		for (int index = 2; index <= fibonacciIndex; index++) {
			fibNums[index] = fibNums[index - 1] + fibNums[index - 2];
		}

		fibonacciNumber.setFibValue(fibNums[fibonacciIndex]);
		fibonacciNumber.setIndex(fibonacciIndex);

		return fibonacciNumber;

	}

}
