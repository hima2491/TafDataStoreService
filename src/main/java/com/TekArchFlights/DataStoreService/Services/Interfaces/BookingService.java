package com.TekArchFlights.DataStoreService.Services.Interfaces;

import com.TekArchFlights.DataStoreService.Models.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    Booking createBooking(Booking booking);
    Optional<Booking> getBookingById(Long bookingId);
    List<Booking> getAllBookings();
    void cancelBooking(Long bookingId);
}
