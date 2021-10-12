package com.cprime.fibonacciservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FibonacciCalculatorTests {

	@Test
	public void contextLoads() {
	}

	@Test
	void zeroIndex() throws FibonacciIndexOutOfBoundsException {
		Assertions.assertEquals(0, FibonacciCalculator.calculateFiboacciNumberByIndex(0).getFibonacciValue());
	}

	@Test
	void oneIndex() throws FibonacciIndexOutOfBoundsException {
		Assertions.assertEquals(1, FibonacciCalculator.calculateFiboacciNumberByIndex(1).getFibonacciValue());
	}

	@Test
	void twentyFiveIndex() throws FibonacciIndexOutOfBoundsException {
		Assertions.assertEquals(75025L, FibonacciCalculator.calculateFiboacciNumberByIndex(25).getFibonacciValue());
	}

	@Test
	void fiftyIndex() throws FibonacciIndexOutOfBoundsException {
		Assertions.assertEquals(12586269025L,
				FibonacciCalculator.calculateFiboacciNumberByIndex(50).getFibonacciValue());
	}

	@Test
	void seventyFiveIndex() throws FibonacciIndexOutOfBoundsException {
		Assertions.assertEquals(2111485077978050L,
				FibonacciCalculator.calculateFiboacciNumberByIndex(75).getFibonacciValue());
	}

	@Test
	void seventySixIndexThrowsFibonacciIndexOutOfBoundsException() {
		Assertions.assertThrows(FibonacciIndexOutOfBoundsException.class, () -> {
			FibonacciCalculator.calculateFiboacciNumberByIndex(76);
		});
	}

	@Test
	void minusOneIndexThrowsFibonacciIndexOutOfBoundsException() {
		Assertions.assertThrows(FibonacciIndexOutOfBoundsException.class, () -> {
			FibonacciCalculator.calculateFiboacciNumberByIndex(-1);
		});
	}

}
