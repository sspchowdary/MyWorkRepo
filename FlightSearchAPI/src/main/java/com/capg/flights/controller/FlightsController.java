package com.capg.flights.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.flights.entities.Flights;
import com.capg.flights.service.IFlightsServiceImpl;

@RestController("/flightSearch")
public class FlightsController {

	@Autowired
	private IFlightsServiceImpl flightsService;
	
	List<Flights> list;
	
	@GetMapping("/getFlights")
	public List<Flights> getFlightsByOriginDestination(@RequestParam String origin, @RequestParam String destination,
			@RequestParam(value="filter",defaultValue="false") String filter){
		list = new ArrayList<Flights>();
		list = flightsService.findByOriginDestination(origin,destination,filter);
		return list;
	}
	
	@PostMapping("/addFlight")
	public Flights addFlight(@RequestBody Flights flight) {
		Flights f = flightsService.addFlight(flight);
		return f;
	}
	
}
