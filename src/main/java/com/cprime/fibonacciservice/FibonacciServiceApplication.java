package com.cprime.fibonacciservice;

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

	@GetMapping("/")
	String home() {
		return "Fibonacci Calculator is running!";
	}

	@RequestMapping(value = "/health", method = RequestMethod.GET, produces = { "application/json" })
	FibonacciServiceStatus health() {
		return new FibonacciServiceStatus();
	}

	@RequestMapping(value = "/fibonacci/{count}", method = RequestMethod.GET, produces = { "application/json" })
	FibonacciNumber fibonacci(@PathVariable("count") int count) {
		FibonacciNumber fibNum = new FibonacciNumber();

		if (count <= 1) {
			fibNum.setFibValue(count);
			fibNum.setIndex(count);
			return fibNum;
		}

		int[] fibNums = new int[count + 1];
		fibNums[0] = 0;
		fibNums[1] = 1;
		for (int index = 2; index <= count; index++) {
			fibNums[index] = fibNums[index - 1] + fibNums[index - 2];
		}
		fibNum.setFibValue(fibNums[count]);
		fibNum.setIndex(count);
		return fibNum;
	}

}
