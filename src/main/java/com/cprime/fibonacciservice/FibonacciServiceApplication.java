package com.cprime.fibonacciservice;

import com.cprime.fibonacciservice.health.*;
import com.cprime.fibonacciservice.exceptions.*;
import com.cprime.fibonacciservice.utils.FibonacciServiceUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class FibonacciServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FibonacciServiceApplication.class, args);
	}

	@GetMapping
	FibonacciServiceStatus root() {
		return new FibonacciServiceStatus();
	}

	@GetMapping(path = "/health")
	FibonacciServiceStatus health() {
		return new FibonacciServiceStatus();
	}

	@GetMapping(path = "/fibonacci/{fibonacciIndex}")
	FibonacciNumber fibonacci(@PathVariable("fibonacciIndex") String fibonacciIndex)
			throws FibonacciIndexOutOfBoundsException, FibonacciIndexWrongTypeException {

		FibonacciServiceUtils.validateInteger(fibonacciIndex);
		
		return FibonacciCalculator.calculateFiboacciNumberByIndex(Integer.parseInt(fibonacciIndex));
	}

}
