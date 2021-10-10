package com.cprime.fibonacciservice;

public class FibonacciCalculator {

    public static FibonacciNumber calculateFiboacciNumberByIndex(int fibonacciIndex) {

        FibonacciNumber fibNum = new FibonacciNumber();

		if (fibonacciIndex <= 1) {
			fibNum.setFibValue(fibonacciIndex);
			fibNum.setIndex(fibonacciIndex);
			return fibNum;
		}

		int[] fibNums = new int[fibonacciIndex + 1];
		fibNums[0] = 0;
		fibNums[1] = 1;
		for (int index = 2; index <= fibonacciIndex; index++) {
			fibNums[index] = fibNums[index - 1] + fibNums[index - 2];
		}
		fibNum.setFibValue(fibNums[fibonacciIndex]);
		fibNum.setIndex(fibonacciIndex);
		return fibNum;
        
    }
    
}
