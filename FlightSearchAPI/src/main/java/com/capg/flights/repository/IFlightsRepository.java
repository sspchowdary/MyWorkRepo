package com.capg.flights.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.flights.entities.Flights;

@Repository
public interface IFlightsRepository extends JpaRepository<Flights,Integer>{
	
	@Query(value="select * from Flights where origin=:org and destination=:dest",nativeQuery=true)
	List<Flights> findByOriginDestination(@Param("org") String origin,
										  @Param("dest") String destination);

}
