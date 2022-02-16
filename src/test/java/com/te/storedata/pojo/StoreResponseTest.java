package com.te.storedata.pojo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class StoreResponseTest {

	String json = "{\"error\":false,\"message\":\"message\"}";
	ObjectMapper mapper = new ObjectMapper();

	@Test
	void serializationTest() throws JsonProcessingException {
		StoreResponse response = new StoreResponse(false, "message", null, null);
//		System.out.println(mapper.writeValueAsString(response));

		StoreResponse readValue = mapper.readValue(json, StoreResponse.class);

		assertEquals(json, mapper.writeValueAsString(readValue));

	}

	@Test
	void deserializationTest() throws JsonMappingException, JsonProcessingException {

		StoreResponse readValue = mapper.readValue(json, StoreResponse.class);

		assertEquals(json, mapper.writeValueAsString(readValue));
	}

}
