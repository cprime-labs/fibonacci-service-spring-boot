package com.cprime.fibonacciservice;

import org.junit.jupiter.api.Test;
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

	@Test
	void zeroIndexRequestReturnsCorrectValue() {
		FibonacciNumber response = this.restTemplate.getForObject("/fibonacci/0", FibonacciNumber.class);
		Assertions.assertEquals(0, response.getFibonacciIndex());
		Assertions.assertEquals(0, response.getFibonacciValue());
	}

	@Test
	void twentyFiveIndexRequestReturnsCorrectValue() {
		FibonacciNumber response = this.restTemplate.getForObject("/fibonacci/25", FibonacciNumber.class);
		Assertions.assertEquals(25, response.getFibonacciIndex());
		Assertions.assertEquals(75025L, response.getFibonacciValue());
	}

	@Test
	void fiftyIndexRequestReturnsCorrectValue() {
		FibonacciNumber response = this.restTemplate.getForObject("/fibonacci/50", FibonacciNumber.class);
		Assertions.assertEquals(50, response.getFibonacciIndex());
		Assertions.assertEquals(12586269025L, response.getFibonacciValue());
	}

	@Test
	void seventyFiveIndexRequestReturnsCorrectValue() {
		FibonacciNumber response = this.restTemplate.getForObject("/fibonacci/75", FibonacciNumber.class);
		Assertions.assertEquals(75, response.getFibonacciIndex());
		Assertions.assertEquals(2111485077978050L, response.getFibonacciValue());
	}

	@Test
	void seventySixIndexRequestThrowsInternalServerError() throws JSONException {
		String response = this.restTemplate.getForObject("/fibonacci/76", String.class);
		JSONObject object = new JSONObject(response);
		Assertions.assertEquals(500, object.getInt("status"));
		Assertions.assertEquals("Internal Server Error", object.getString("error"));
		Assertions.assertEquals("/fibonacci/76", object.getString("path"));
	}

	@Test
	void minusOneIndexRequestThrowsInternalServerError() throws JSONException {
		String response = this.restTemplate.getForObject("/fibonacci/-1", String.class);
		JSONObject object = new JSONObject(response);
		Assertions.assertEquals(500, object.getInt("status"));
		Assertions.assertEquals("Internal Server Error", object.getString("error"));
		Assertions.assertEquals("/fibonacci/-1", object.getString("path"));
	}

	@Test
	void floatingPointIndexRequestThrowsInternalServerError() throws JSONException {
		String response = this.restTemplate.getForObject("/fibonacci/1.5", String.class);
		JSONObject object = new JSONObject(response);
		Assertions.assertEquals(500, object.getInt("status"));
		Assertions.assertEquals("Internal Server Error", object.getString("error"));
		Assertions.assertEquals("/fibonacci/1.5", object.getString("path"));
	}

	@Test
	void stringIndexRequestThrowsInternalServerError() throws JSONException {
		String response = this.restTemplate.getForObject("/fibonacci/one", String.class);
		JSONObject object = new JSONObject(response);
		Assertions.assertEquals(500, object.getInt("status"));
		Assertions.assertEquals("Internal Server Error", object.getString("error"));
		Assertions.assertEquals("/fibonacci/one", object.getString("path"));
	}

}
