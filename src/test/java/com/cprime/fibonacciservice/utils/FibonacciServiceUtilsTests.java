package com.cprime.fibonacciservice.utils;

import com.cprime.fibonacciservice.exceptions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FibonacciServiceUtilsTests {

    @Test
	void floatingPointIndexThrowsFibonacciIndexWrongTypeException() {
		Assertions.assertThrows(FibonacciIndexWrongTypeException.class, () -> {
			FibonacciServiceUtils.validateInteger("1.5");
		});
	}

    @Test
	void stringIndexThrowsFibonacciIndexWrongTypeException() {
		Assertions.assertThrows(FibonacciIndexWrongTypeException.class, () -> {
			FibonacciServiceUtils.validateInteger("one");
		});
	}

    @Test
	void integerIndexDoesNotThrowFibonacciIndexWrongTypeException() {
        Assertions.assertDoesNotThrow( () -> FibonacciServiceUtils.validateInteger("1") );
	}

	@Test
	void seventySixIndexThrowsFibonacciIndexOutOfBoundsException() {
		Assertions.assertThrows(FibonacciIndexOutOfBoundsException.class, () -> {
			FibonacciServiceUtils.validateIntegerIndexBounds(76);
		});
	}

	@Test
	void minusOneIndexThrowsFibonacciIndexOutOfBoundsException() {
		Assertions.assertThrows(FibonacciIndexOutOfBoundsException.class, () -> {
			FibonacciServiceUtils.validateIntegerIndexBounds(-1);
		});
	}
    
}
