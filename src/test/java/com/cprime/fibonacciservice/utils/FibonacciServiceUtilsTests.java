package com.cprime.fibonacciservice.utils;

import com.cprime.fibonacciservice.exceptions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import java.lang.reflect.Modifier;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@SpringBootTest
class FibonacciServiceUtilsTests {

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

	@Test
	void testFibonacciCalculatorConstructorIsPrivate()
			throws IllegalStateException, NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor<FibonacciServiceUtils> constructor = FibonacciServiceUtils.class.getDeclaredConstructor();
		Assertions.assertTrue(Modifier.isPrivate(constructor.getModifiers()));
	}

	@Test
	void testFibonacciServiceUtilsConstructorThrowsIllegalStateException()
			throws IllegalStateException, NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor<FibonacciServiceUtils> constructor = FibonacciServiceUtils.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		try {
			constructor.newInstance();
		} catch (InvocationTargetException ex) {
			Assertions.assertThrows(IllegalStateException.class, () -> {
				throw ex.getCause();
			});
		}
	}
    
}
