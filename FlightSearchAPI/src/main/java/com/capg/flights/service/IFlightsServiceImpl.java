package com.capg.flights.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.flights.entities.Flights;
import com.capg.flights.repository.IFlightsRepository;

@Service
public class IFlightsServiceImpl implements IFlightsService{
	
	@Autowired
	private IFlightsRepository flightsRepo;
	
	List<Flights> flightsList;
	
	Flights f;
	
	@Override
	public List<Flights> findByOriginDestination(String origin, String destination, String filter){
		flightsList = new ArrayList<Flights>();
		flightsList = flightsRepo.findByOriginDestination(origin,destination);
		if(filter.equals("price")) {
			flightsList.sort(Comparator.comparingInt(Flights::getPrice));
		}else if(filter.equalsIgnoreCase("duration")){
			Collections.sort(flightsList, new Comparator<Flights>() {
				@Override
		        public int compare(Flights flight1, Flights flight2) {
		            long duration1 = Duration.between(flight1.getDepartureTime().toLocalTime(),flight1.getArrivalTime().toLocalTime()).toSeconds();
		            long duration2 = Duration.between(flight2.getDepartureTime().toLocalTime(),flight2.getArrivalTime().toLocalTime()).toSeconds();
		            return (int) (duration1 - duration2);
		        }
			});
		}else if(filter.equalsIgnoreCase("flightNumber")) {
			Collections.sort(flightsList, new Comparator<Flights>() {
				@Override
		        public int compare(Flights flight1, Flights flight2) {					
		            return flight1.getFlightNumber().compareTo(flight2.getFlightNumber());		            
		        }
			});
		}
		return flightsList;
	}

	@Override
	public Flights addFlight(Flights flight) {
		f = flightsRepo.save(flight);
		return f;
	}
	
        
}
