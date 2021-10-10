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
	void zeroIndex() throws FibonacciIdexOutOfBoundsException  {
        Assertions.assertEquals(0,FibonacciCalculator.calculateFiboacciNumberByIndex(0).getFibonacciValue());
	}

	@Test
	void oneIndex() throws FibonacciIdexOutOfBoundsException  {
        Assertions.assertEquals(1,FibonacciCalculator.calculateFiboacciNumberByIndex(1).getFibonacciValue());
	}

		@Test
	void twentyFiveIndex() throws FibonacciIdexOutOfBoundsException {
        Assertions.assertEquals(75025L,FibonacciCalculator.calculateFiboacciNumberByIndex(25).getFibonacciValue());
	}

	@Test
	void fiftyIndex() throws FibonacciIdexOutOfBoundsException {
        Assertions.assertEquals(12586269025L,FibonacciCalculator.calculateFiboacciNumberByIndex(50).getFibonacciValue());
	}

	@Test
	void seventyFiveIndex() throws FibonacciIdexOutOfBoundsException {
        Assertions.assertEquals(2111485077978050L,FibonacciCalculator.calculateFiboacciNumberByIndex(75).getFibonacciValue());
	}

	@Test
	void seventySixIndex() {
        Assertions.assertThrows(FibonacciIdexOutOfBoundsException.class, () -> {
			FibonacciCalculator.calculateFiboacciNumberByIndex(76);
		  });
	}

	@Test
	void minusOneIndex() {
        Assertions.assertThrows(FibonacciIdexOutOfBoundsException.class, () -> {
			FibonacciCalculator.calculateFiboacciNumberByIndex(-1);
		  });
	}

}
