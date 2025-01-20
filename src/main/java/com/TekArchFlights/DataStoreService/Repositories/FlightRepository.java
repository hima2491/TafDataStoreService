package com.TekArchFlights.DataStoreService.Repositories;

import com.TekArchFlights.DataStoreService.Models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}