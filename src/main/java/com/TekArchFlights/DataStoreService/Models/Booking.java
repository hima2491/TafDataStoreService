package com.TekArchFlights.DataStoreService.Models;



import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

    @Entity
    @Data
    public class Booking {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long bookingId;

        @ManyToOne(fetch = FetchType.EAGER, optional = false)
        @JoinColumn(name = "user_id", nullable = false)
        private Users user;

       @ManyToOne(fetch = FetchType.EAGER, optional = false)
       @JoinColumn(name = "flight_id", nullable = false)
       private Flight flight;

        @Column(name = "status")
        private String status;  // e.g., "Booked", "Cancelled"
        private int seatsBooked;

        @Column(name = "created_at")
        private LocalDateTime created_at;


        @Column(name = "updated_at")
        private LocalDateTime updated_at;

        protected void onCreate() {
            this.updated_at = LocalDateTime.now();
            this.created_at = LocalDateTime.now();
        }

        @PreUpdate
        protected void onUpdate() {
            this.updated_at=LocalDateTime.now();

        }

    }


