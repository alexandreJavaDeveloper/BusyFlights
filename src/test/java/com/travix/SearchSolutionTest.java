package com.travix;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travix.model.FlightRequest;
import com.travix.model.FlightResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class SearchSolutionTest
{
	private static final String BASE_URL = "http://localhost:8080/";

	private RestTemplate restTemplate;

	@Before
	public void setup()
	{
		this.restTemplate = new RestTemplate();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testValidSearchSolutionCrazyAir() throws JsonGenerationException, JsonMappingException, IOException
	{
		final String url = SearchSolutionTest.BASE_URL + "searchsolution";

		final FlightRequest request = new FlightRequest("LHR", "LHR", "05-10-2010", "06-10-2013", 4);

		final ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("file.json"), request);

		final String requestJson = mapper.writeValueAsString(request);

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		final HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
		final List<Map<String, String>> responseJson = this.restTemplate.postForObject(url, entity, List.class);

		Assert.assertEquals(4, responseJson.size());

		final String listAsJson = mapper.writeValueAsString(responseJson);

		// convert from json to List
		final List<FlightResponse> flightResponse = mapper.readValue(listAsJson, new TypeReference<List<FlightResponse>>(){});

		Assert.assertEquals(4, flightResponse.size());

		Assert.assertEquals("CrazyAir", flightResponse.get(0).getAirline());
		Assert.assertEquals(new Double(90.10), new Double(flightResponse.get(0).getFare()));

		Assert.assertEquals("CrazyAir", flightResponse.get(1).getAirline());
		Assert.assertEquals(new Double(100.10), new Double(flightResponse.get(1).getFare()));

		Assert.assertEquals("ToughJet", flightResponse.get(2).getAirline());
		Assert.assertEquals(new Double(1006.00), new Double(flightResponse.get(2).getFare())); // sum tax

		Assert.assertEquals("ToughJet", flightResponse.get(3).getAirline());
		Assert.assertEquals(new Double(2005.00), new Double(flightResponse.get(3).getFare())); // sum tax
	}
}