package com.TekArchFlights.DataStoreService.Services;


import com.TekArchFlights.DataStoreService.Models.Flight;
import com.TekArchFlights.DataStoreService.Repositories.FlightRepository;
import com.TekArchFlights.DataStoreService.Services.Interfaces.FlightService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }


    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Optional<Flight> getFlightById(Long flightId) {
        return flightRepository.findById(flightId);
    }

    @Override
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Flight updateFlight(Long flightId, Flight flightDetails) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("Flight not found"));
        flight.setFlightNumber(flightDetails.getFlightNumber());
        flight.setDepartureAirport(flightDetails.getDepartureAirport());
        flight.setArrivalAirport(flightDetails.getArrivalAirport());
        flight.setDepartureTime(flightDetails.getDepartureTime());
        flight.setArrivalTime(flightDetails.getArrivalTime());
        flight.setAvailableSeats(flightDetails.getAvailableSeats());
        flight.setAircraftType(flightDetails.getAircraftType());
        return flightRepository.save(flight);
    }

    @Override
    public void deleteFlight(Long flightId) {
        flightRepository.deleteById(flightId);
    }
}

