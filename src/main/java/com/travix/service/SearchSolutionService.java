package com.travix.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SearchSolutionService
{
    private final String URL_CRAZY_AIR = "http://localhost:8090/crazyair/{request}";

    private final String URL_TOUGH_JET = "http://localhost:8090/toughjet/{request}";

    private final RestTemplate restTemplate;

    public SearchSolutionService()
    {
        this.restTemplate = new RestTemplate();
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/searchsolution/{request}", method = RequestMethod.GET)
    public List<Map<String, String>> searchSolution(@PathVariable(value = "request")
    final String requestJson)
    {
        final List<Map<String, String>> flights = new ArrayList<>();

        final List<Map<String, String>> responseJsonCrazyAir = this.restTemplate.getForObject(this.URL_CRAZY_AIR, List.class, requestJson);
        System.out.println(responseJsonCrazyAir.get(0).toString());

        final List<Map<String, String>> responseJsonToughJet = this.restTemplate.getForObject(this.URL_TOUGH_JET, List.class, requestJson);
        System.out.println(responseJsonToughJet.get(0).toString());

        //        final ObjectMapper mapper = new ObjectMapper();
        //
        //        List<Staff> list = mapper.readValue(json, new TypeReference(<List<FlightResponse>>(){});

        // TODO aqui devo transformar de json para objeto (lista), obter apenas como FlightResponse (objetos de retorno) e fazer o sort

        // ordenar lista por fare

        //        flights.addAll(responseJsonCrazyAir);
        //        flights.addAll(responseJsonToughJet);

        return flights;
    }
}