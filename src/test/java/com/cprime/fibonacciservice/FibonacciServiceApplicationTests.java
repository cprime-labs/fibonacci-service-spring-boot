package com.cprime.fibonacciservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.junit.jupiter.api.Assertions;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FibonacciServiceApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;;

	@Test
	void contextLoads() {
	}

	@Test
	void rootRequestReturnsSystemUpMessage() {
		FibonacciServiceStatus response = this.restTemplate.getForObject("/", FibonacciServiceStatus.class);
		Assertions.assertEquals("UP", response.getStatus());
	}

	@Test
	void healthRequestReturnsSystemUpMessage() {
		FibonacciServiceStatus response = this.restTemplate.getForObject("/health", FibonacciServiceStatus.class);
		Assertions.assertEquals("UP", response.getStatus());
	}

	@Test
	void zeroIndexRequestReturnsCorrectValue() {
		FibonacciNumber response = this.restTemplate.getForObject("/fibonacci/0", FibonacciNumber.class);
		Assertions.assertEquals(0, response.getFibonacciIndex());
		Assertions.assertEquals(0, response.getFibonacciValue());
	}

}
