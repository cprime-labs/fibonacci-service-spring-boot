package com.cprime.fibonacciservice;

import com.cprime.fibonacciservice.exceptions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import java.lang.reflect.Modifier;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@SpringBootTest
class FibonacciCalculatorTests {

	@ParameterizedTest
    @CsvFileSource(resources = "/fibonacci-index-value-mapping.csv", numLinesToSkip = 1)
    void calculateFibonacciNumberByIndexReturnsCorrectValues(int input, long expected) throws FibonacciIndexOutOfBoundsException {
        Assertions.assertEquals(expected, FibonacciCalculator.calculateFiboacciNumberByIndex(input).getFibonacciValue());
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
