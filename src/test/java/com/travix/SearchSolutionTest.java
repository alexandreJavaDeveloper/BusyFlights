package com.travix;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travix.model.FlightRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class SearchSolutionTest
{
    /**
     * TODO valid the date ISO8601 and variables that has max numbers
     */
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
        final String url = SearchSolutionTest.BASE_URL + "searchsolution/{request}";

        final FlightRequest request = new FlightRequest("LHR", "LHR", "05-10-2010", "06-10-2013", 4);

        final ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("file.json"), request);

        final String requestJson = mapper.writeValueAsString(request);

        final List<Map<String, String>> responseJson = this.restTemplate.getForObject(url, List.class, requestJson);

        System.out.println(responseJson);
    }
}