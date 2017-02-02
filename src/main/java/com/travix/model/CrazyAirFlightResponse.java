package com.travix.model;

public class CrazyAirFlightResponse
{
	private String airline;

	private double price;

	private char cabinclass;

	private String departureAirportCode;

	private String destinationAirportCode;

	private String departureDate;

	private String arrivalDate;

	public String getAirline()
	{
		return this.airline;
	}

	public void setAirline(final String airline)
	{
		this.airline = airline;
	}

	public double getPrice()
	{
		return this.price;
	}

	public void setPrice(final double price)
	{
		this.price = price;
	}

	public char getCabinclass()
	{
		return this.cabinclass;
	}

	public void setCabinclass(final char cabinclass)
	{
		this.cabinclass = cabinclass;
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

	public String getDepartureDate()
	{
		return this.departureDate;
	}

	public void setDepartureDate(final String departureDate)
	{
		this.departureDate = departureDate;
	}

	public String getArrivalDate()
	{
		return this.arrivalDate;
	}

	public void setArrivalDate(final String arrivalDate)
	{
		this.arrivalDate = arrivalDate;
	}

	@Override
	public String toString()
	{
		final StringBuffer buffer = new StringBuffer();
		buffer.append("Airline [" + this.airline + "], ");
		buffer.append("Price [" + this.price + "], ");
		buffer.append("Cabinclass [" + this.cabinclass + "], ");
		buffer.append("DepartureAirportCode [" + this.departureAirportCode + "], ");
		buffer.append("DestinationAirportCode [" + this.destinationAirportCode + "], ");
		buffer.append("DepartureDate [" + this.departureDate + "], ");
		buffer.append("ArrivalDate [" + this.arrivalDate + "].");
		return buffer.toString();
	}
}