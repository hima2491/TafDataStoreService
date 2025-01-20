package com.TekArchFlights.DataStoreService.Controller;


import com.TekArchFlights.DataStoreService.Models.Flight;
import com.TekArchFlights.DataStoreService.Services.Interfaces.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{flightId}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long flightId) {
        Optional<Flight> flight = flightService.getFlightById(flightId);
        return flight.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        Flight savedFlight = flightService.addFlight(flight);
        return new ResponseEntity<>(savedFlight, HttpStatus.CREATED);
    }

    @PutMapping("/{flightId}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long flightId, @RequestBody Flight flightDetails) {
        Flight updatedFlight = flightService.updateFlight(flightId, flightDetails);
        return ResponseEntity.ok(updatedFlight);
    }


    @DeleteMapping("/{flightId}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long flightId) {
        flightService.deleteFlight(flightId);
        return ResponseEntity.noContent().build();
    }
}
