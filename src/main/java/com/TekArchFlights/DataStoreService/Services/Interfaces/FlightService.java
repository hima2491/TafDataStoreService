package com.TekArchFlights.DataStoreService.Services.Interfaces;

import com.TekArchFlights.DataStoreService.Models.Flight;

import java.util.List;
import java.util.Optional;

public interface FlightService {
    List<Flight> getAllFlights();

    Optional<Flight> getFlightById(Long flightId);

    Flight addFlight(Flight flight);

    Flight updateFlight(Long flightId, Flight flightDetails);

    void deleteFlight(Long flightId);
}
