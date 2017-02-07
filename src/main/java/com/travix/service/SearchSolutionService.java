package com.travix.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travix.formatter.ValueFormatter;
import com.travix.formatter.ValueFormatterCrazyAir;
import com.travix.formatter.ValueFormatterToughJet;
import com.travix.model.CrazyAirFlightResponse;
import com.travix.model.FlightRequest;
import com.travix.model.FlightResponse;
import com.travix.model.Supplier;
import com.travix.model.ToughJetFlightResponse;

@RestController
public class SearchSolutionService
{
    private final String URL_CRAZY_AIR = "http://localhost:8090/crazyair";

    private final String URL_TOUGH_JET = "http://localhost:8090/toughjet";

    // Thread-safe, so can be and must be instantiated once (performance)
    private final RestTemplate restTemplate;

    // Thread-safe
    private final ObjectMapper mapper;

    private final TypeReference<List<CrazyAirFlightResponse>> typeReferenceCrazyAir;

    private final TypeReference<List<ToughJetFlightResponse>> typeReferenceToughJet;

    public SearchSolutionService()
    {
        this.restTemplate = new RestTemplate();
        this.mapper = new ObjectMapper();
        this.typeReferenceCrazyAir = new TypeReference<List<CrazyAirFlightResponse>>(){};
        this.typeReferenceToughJet = new TypeReference<List<ToughJetFlightResponse>>(){};
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/searchsolution", method = RequestMethod.POST)
    public List<FlightResponse> searchSolution(@RequestBody
    final FlightRequest request) throws JsonGenerationException, JsonMappingException, IOException
    {
        this.mapper.writeValue(new File("file.json"), request);

        // the consumes and produces is by default JSON, that's why I can send FlightRequest in the body
        final List<Map<String, String>> responseJsonCrazyAir = this.restTemplate.postForObject(this.URL_CRAZY_AIR, request, List.class);
        final List<Map<String, String>> responseJsonToughJet = this.restTemplate.postForObject(this.URL_TOUGH_JET, request, List.class);

        final String listCrazyAirAsJson = this.mapper.writeValueAsString(responseJsonCrazyAir);
        final String listCrazyToughJetJson = this.mapper.writeValueAsString(responseJsonToughJet);

        final List<CrazyAirFlightResponse> crazyAirFlightResponseList = this.mapper.readValue(listCrazyAirAsJson, this.typeReferenceCrazyAir);
        final List<ToughJetFlightResponse> toughJetFlightResponse = this.mapper.readValue(listCrazyToughJetJson, this.typeReferenceToughJet);

        final List<FlightResponse> flightsCrazyAir = this.convertCrazyAirSupplier(crazyAirFlightResponseList);
        final List<FlightResponse> flightsToughJet = this.convertToughJetSupplier(toughJetFlightResponse);

        final List<FlightResponse> flights = new ArrayList<>();
        flights.addAll(flightsCrazyAir);
        flights.addAll(flightsToughJet);

        Collections.sort(flights);

        return flights;
    }

    private List<FlightResponse> convertToughJetSupplier(final List<ToughJetFlightResponse> toughJetFlightResponse)
    {
        final List<FlightResponse> flights = new ArrayList<>();

        for (final ToughJetFlightResponse object : toughJetFlightResponse)
        {
            final FlightResponse flightResponse = new FlightResponse();
            flightResponse.setAirline(object.getCarrier());
            flightResponse.setSupplier(Supplier.TOUGH_JET.getName());
            flightResponse.setFare(ValueFormatter.round(object.getBasePrice() + object.getTax()));
            flightResponse.setDepartureAirportCode(object.getDepartureAirportName());
            flightResponse.setDestinationAirportCode(object.getArrivalAirportName());
            flightResponse.setDepartureDate(ValueFormatterToughJet.getDateTimeISO8801(object.getDepartureDay(), object.getDepartureMonth(), object.getDepartureYear()));
            flightResponse.setArrivalDate(ValueFormatterToughJet.getDateTimeISO8801(object.getReturnDay(), object.getReturnMonth(), object.getReturnYear()));
            flights.add(flightResponse);
        }

        return flights;
    }

    private List<FlightResponse> convertCrazyAirSupplier(final List<CrazyAirFlightResponse> crazyAirFlightResponseList)
    {
        final List<FlightResponse> flights = new ArrayList<>();

        for (final CrazyAirFlightResponse object : crazyAirFlightResponseList)
        {
            final FlightResponse flightResponse = new FlightResponse();
            flightResponse.setAirline(object.getAirline());
            flightResponse.setSupplier(Supplier.CRAZY_AIR.getName());
            flightResponse.setFare(ValueFormatter.round(object.getPrice()));
            flightResponse.setDepartureAirportCode(ValueFormatter.getLetterIATACode(object.getDepartureAirportCode()));
            flightResponse.setDestinationAirportCode(ValueFormatter.getLetterIATACode(object.getDestinationAirportCode()));
            flightResponse.setDepartureDate(ValueFormatterCrazyAir.getDateTimeISO8801(object.getDepartureDate()));
            flightResponse.setArrivalDate(ValueFormatterCrazyAir.getDateTimeISO8801(object.getArrivalDate()));
            flights.add(flightResponse);
        }

        return flights;
    }
}