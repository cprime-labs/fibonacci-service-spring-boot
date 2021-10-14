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

	@Test
	void seventySixIndexRequestThrowsInternalServerError() throws JSONException {
		String response = this.restTemplate.getForObject("/fibonacci/76", String.class);
		JSONObject object = new JSONObject(response);
		Assertions.assertEquals("INTERNAL_SERVER_ERROR", object.getString("status"));
		Assertions.assertEquals("The minimum index this service can calculate a Fibonacci number for is '0' and maximum index this service can calculate a Fibonacci number for is '75'", object.getString("message"));
	}

	@Test
	void minusOneIndexRequestThrowsInternalServerError() throws JSONException {
		String response = this.restTemplate.getForObject("/fibonacci/-1", String.class);
		JSONObject object = new JSONObject(response);
		Assertions.assertEquals("INTERNAL_SERVER_ERROR", object.getString("status"));
		Assertions.assertEquals("The minimum index this service can calculate a Fibonacci number for is '0' and maximum index this service can calculate a Fibonacci number for is '75'", object.getString("message"));
	}

	@Test
	void floatingPointIndexRequestThrowsInternalServerError() throws JSONException {
		String response = this.restTemplate.getForObject("/fibonacci/1.5", String.class);
		JSONObject object = new JSONObject(response);
		Assertions.assertEquals("INTERNAL_SERVER_ERROR", object.getString("status"));
		Assertions.assertEquals("Index value must be an integer.", object.getString("message"));
	}

	@Test
	void stringIndexRequestThrowsInternalServerError() throws JSONException {
		String response = this.restTemplate.getForObject("/fibonacci/one", String.class);
		JSONObject object = new JSONObject(response);
		Assertions.assertEquals("INTERNAL_SERVER_ERROR", object.getString("status"));
		Assertions.assertEquals("Index value must be an integer.", object.getString("message"));
	}

}
