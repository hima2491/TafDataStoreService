package com.TekArchFlights.DataStoreService.Services;


import com.TekArchFlights.DataStoreService.Models.Booking;
import com.TekArchFlights.DataStoreService.Repositories.BookingRepository;
import com.TekArchFlights.DataStoreService.Services.Interfaces.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Optional<Booking> getBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public void cancelBooking(Long bookingId) {
        Optional<Booking> bookingOptional = bookingRepository.findById(bookingId);
        bookingOptional.ifPresent(booking -> {
            booking.setStatus("Cancelled");
            bookingRepository.save(booking);
        });
    }
}
