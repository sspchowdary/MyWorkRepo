package com.capg.flights.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capg.flights.entities.Flights;
import com.capg.flights.service.IFlightsServiceImpl;

@ExtendWith(MockitoExtension.class)
class FlightsControllerTest {
	
	@Mock
	private IFlightsServiceImpl flightsService;
	
	@InjectMocks
	private FlightsController flightsController;
	
	static List<Flights> flightsList = new ArrayList<Flights>();
	static List<Flights> flightsListByPrice = new ArrayList<Flights>();
	static List<Flights> flightsListByDuration = new ArrayList<Flights>();
	static List<Flights> flightsListByFlightNumber = new ArrayList<Flights>();
	
	@BeforeAll
	static void createMockFlightsObjects(){
		
		Flights f1 = new Flights(6,"F101","BOM","DEL",new Time(20,30,00),new Time(21,30,00),80);
		Flights f2 = new Flights(7,"G101","BOM","DEL",new Time(18,00,00),new Time(19,30,00),100);
		Flights f3 = new Flights(13,"F201","BOM","DEL",new Time(21,15,00),new Time(22,30,00),80);
		Flights f4 = new Flights(14,"G201","BOM","DEL",new Time(20,20,00),new Time(21,30,00),100);
		
		flightsList.add(f1);
		flightsList.add(f2);
		flightsList.add(f3);
		flightsList.add(f4);

		flightsListByPrice.add(f1);
		flightsListByPrice.add(f3);
		flightsListByPrice.add(f2);
		flightsListByPrice.add(f4);
		
		flightsListByDuration.add(f1);
		flightsListByDuration.add(f4);
		flightsListByDuration.add(f3);
		flightsListByDuration.add(f2);
		
		flightsListByFlightNumber.add(f1);
		flightsListByFlightNumber.add(f3);
		flightsListByFlightNumber.add(f2);
		flightsListByFlightNumber.add(f4);
			
	}

	@Test
	void testGetFlightsByOriginDestination() {		
		
		when(flightsService.findByOriginDestination("BOM", "DEL", "false")).thenReturn(flightsList);
		
		List<Flights> expected = flightsList;
		
		assertEquals(expected,flightsController.getFlightsByOriginDestination("BOM", "DEL", "false"));		
	}
	
	@Test
	void testGetFlightsByOriginDestinationOrderByPrice() {
		
		when(flightsService.findByOriginDestination("BOM", "DEL", "price")).thenReturn(flightsListByPrice);
		
		List<Flights> expected = flightsListByPrice;
		
		List<Flights> actual = flightsController.getFlightsByOriginDestination("BOM", "DEL", "price");
		
		assertEquals(expected,actual);
	}
	
	@Test
	void testGetFlightsByOriginDestinationOrderByDuration() {
		
		when(flightsService.findByOriginDestination("BOM", "DEL", "duration")).thenReturn(flightsListByDuration);
		
		List<Flights> expected = flightsListByDuration;
		
		List<Flights> actual = flightsController.getFlightsByOriginDestination("BOM", "DEL", "duration");
		
		assertEquals(expected,actual);
	}
	
	@Test
	void testGetFlightsByOriginDestinationOrderByFlightNumber() {
		
		when(flightsService.findByOriginDestination("BOM", "DEL", "flightNumber")).thenReturn(flightsListByFlightNumber);
		
		List<Flights> expected = flightsListByFlightNumber;
		
		List<Flights> actual = flightsController.getFlightsByOriginDestination("BOM", "DEL", "flightNumber");
		
		assertEquals(expected,actual);
	}

}
