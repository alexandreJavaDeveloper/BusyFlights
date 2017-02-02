package com.travix.model;

import java.time.LocalDate;

public class FlightResponse implements Comparable<FlightResponse>
{
	private String airline;

	private String supplier;

	private double fare;

	private String departureAirportCode;

	private String destinationAirportCode;

	private LocalDate departureDate;

	private LocalDate arrivalDate;

	public FlightResponse()
	{

	}

	public FlightResponse(final String airline, final Supplier supplier, final double fare, final String departureAirportCode,
			final String destinationAirportCode, final LocalDate departureDate, final LocalDate arrivalDate)
	{
		super();
		this.airline = airline;
		this.supplier = supplier.getName();
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

	public String getSupplier()
	{
		return this.supplier;
	}

	public void setSupplier(final String supplier)
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

	public LocalDate getDepartureDate()
	{
		return this.departureDate;
	}

	public void setDepartureDate(final LocalDate departureDate)
	{
		this.departureDate = departureDate;
	}

	public LocalDate getArrivalDate()
	{
		return this.arrivalDate;
	}

	public void setArrivalDate(final LocalDate arrivalDate)
	{
		this.arrivalDate = arrivalDate;
	}

	@Override
	public int compareTo(final FlightResponse anotherFlight)
	{
		if (this.fare > anotherFlight.getFare())
			return 1;

		if (this.fare < anotherFlight.getFare())
			return -1;

		return 0;
	}
}