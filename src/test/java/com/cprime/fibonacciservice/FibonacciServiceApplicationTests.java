package com.cprime.fibonacciservice;

import com.cprime.fibonacciservice.health.*;
import com.cprime.fibonacciservice.exceptions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.junit.jupiter.api.Assertions;
import org.json.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FibonacciServiceApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	private static final String SYSTEM_STATUS = "UP";

	@Test
	void contextLoads() {
	}

	@Test
	void rootRequestReturnsSystemUpMessage() {
		FibonacciServiceStatus response = this.restTemplate.getForObject("/", FibonacciServiceStatus.class);
		Assertions.assertEquals(SYSTEM_STATUS, response.getStatus());
	}

	@Test
	void healthRequestReturnsSystemUpMessage() {
		FibonacciServiceStatus response = this.restTemplate.getForObject("/health", FibonacciServiceStatus.class);
		Assertions.assertEquals(SYSTEM_STATUS, response.getStatus());
	}

	@ParameterizedTest
    @CsvFileSource(resources = "/fibonacci-index-value-mapping.csv", numLinesToSkip = 1)
    void fibonacciIndexRequestReturnsCorrectValue(int input, long expected) throws FibonacciIndexOutOfBoundsException {

		FibonacciNumber response = this.restTemplate.getForObject(String.format("/fibonacci/%s",input), FibonacciNumber.class);
		Assertions.assertEquals(input, response.getFibonacciIndex());
		Assertions.assertEquals(expected, response.getFibonacciValue());
    }

}
