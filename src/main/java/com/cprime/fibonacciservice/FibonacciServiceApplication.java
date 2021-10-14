package com.cprime.fibonacciservice;

import com.cprime.fibonacciservice.exceptions.*;
import com.cprime.fibonacciservice.utils.FibonacciServiceUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
@RestController
public class FibonacciServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FibonacciServiceApplication.class, args);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = { "application/json" })
	FibonacciServiceStatus root() {
		return new FibonacciServiceStatus();
	}

	@RequestMapping(value = "/health", method = RequestMethod.GET, produces = { "application/json" })
	FibonacciServiceStatus health() {
		return new FibonacciServiceStatus();
	}

	@RequestMapping(value = "/fibonacci/{fibonacciIndex}", method = RequestMethod.GET, produces = {
			"application/json" })
	FibonacciNumber fibonacci(@PathVariable("fibonacciIndex") String fibonacciIndex)
			throws FibonacciIndexOutOfBoundsException, FibonacciIndexWrongTypeException {

		FibonacciServiceUtils.validateInteger(fibonacciIndex);
		
		return FibonacciCalculator.calculateFiboacciNumberByIndex(Integer.parseInt(fibonacciIndex));
	}

}
