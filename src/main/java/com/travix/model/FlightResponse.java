package com.travix.model;

import java.util.Date;

public class FlightResponse
{
    private String airline;

    private Supplier supplier;

    private double fare;

    private String departureAirportCode;

    private String destinationAirportCode;

    private Date departureDate;

    private Date arrivalDate;

    public FlightResponse()
    {

    }

    public FlightResponse(final String airline, final Supplier supplier, final double fare, final String departureAirportCode,
        final String destinationAirportCode, final Date departureDate, final Date arrivalDate)
    {
        super();
        this.airline = airline;
        this.supplier = supplier;
        this.fare = fare;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public String getAirline()
    {
        return this.airline;
    }

    public void setAirline(final String airline)
    {
        this.airline = airline;
    }

    public Supplier getSupplier()
    {
        return this.supplier;
    }

    public void setSupplier(final Supplier supplier)
    {
        this.supplier = supplier;
    }

    public double getFare()
    {
        return this.fare;
    }

    public void setFare(final double fare)
    {
        this.fare = fare;
    }

    public String getDepartureAirportCode()
    {
        return this.departureAirportCode;
    }

    public void setDepartureAirportCode(final String departureAirportCode)
    {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDestinationAirportCode()
    {
        return this.destinationAirportCode;
    }

    public void setDestinationAirportCode(final String destinationAirportCode)
    {
        this.destinationAirportCode = destinationAirportCode;
    }

    public Date getDepartureDate()
    {
        return this.departureDate;
    }

    public void setDepartureDate(final Date departureDate)
    {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate()
    {
        return this.arrivalDate;
    }

    public void setArrivalDate(final Date arrivalDate)
    {
        this.arrivalDate = arrivalDate;
    }
}