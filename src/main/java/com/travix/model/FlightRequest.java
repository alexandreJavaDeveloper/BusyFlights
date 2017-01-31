package com.travix.model;

public class FlightRequest
{
    private String origin;

    private String destination;

    private String departureDate;

    private String returnDate;

    private int numberOfPassengers;

    public FlightRequest()
    {

    }

    public FlightRequest(final String origin, final String destination, final String departureDate, final String returnDate, final int numberOfPassengers)
    {
        super();
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getOrigin()
    {
        return this.origin;
    }

    public void setOrigin(final String origin)
    {
        this.origin = origin;
    }

    public String getDestination()
    {
        return this.destination;
    }

    public void setDestination(final String destination)
    {
        this.destination = destination;
    }

    public String getDepartureDate()
    {
        return this.departureDate;
    }

    public void setDepartureDate(final String departureDate)
    {
        this.departureDate = departureDate;
    }

    public String getReturnDate()
    {
        return this.returnDate;
    }

    public void setReturnDate(final String returnDate)
    {
        this.returnDate = returnDate;
    }

    public int getNumberOfPassengers()
    {
        return this.numberOfPassengers;
    }

    public void setNumberOfPassengers(final int numberOfPassengers)
    {
        this.numberOfPassengers = numberOfPassengers;
    }
}