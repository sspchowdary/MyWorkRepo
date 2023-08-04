package com.capg.flights.entities;

import java.sql.Time;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@AllArgsConstructor @NoArgsConstructor @ToString
@Entity
@Table(name="Flights")
public class Flights{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	private int flightId;
	@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	private String flightNumber;
	@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	private String origin;
	@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	private String destination;
	@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	private Time departureTime;
	@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	private Time arrivalTime;
	@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	private int price;
	
}
