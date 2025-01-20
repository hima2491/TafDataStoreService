package com.TekArchFlights.DataStoreService.Models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "flights")
@Data
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private Long flightid;


    @Column(nullable = false )
    private String flightNumber;

    @Column(nullable = false)
    private String departureAirport;

    @Column(nullable = false)
    private String arrivalAirport;

    @Column(nullable = false)
    private String departureTime;

    @Column(nullable = false)
    private String arrivalTime;

    @Column(name = "aircraft_type")
    private String aircraftType;


    @Column(nullable = false)
    private int availableSeats;

    @Column(name = "destination")
    private String destination;


}
