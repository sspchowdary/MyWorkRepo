package com.capg.flights.service;

import java.util.List;

import com.capg.flights.entities.Flights;

public interface IFlightsService{
	
	public Flights addFlight(Flights flight);
	
	public List<Flights> findByOriginDestination(String origin, String destination, String filter);
}
