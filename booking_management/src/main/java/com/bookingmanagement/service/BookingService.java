package com.bookingmanagement.service;

import java.util.List;

import com.bookingmanagement.entity.Booking;

public interface BookingService {
    Booking createBooking(Long userId, Long showId, int numberOfSeats, List<String> seatNumbers);
    List<Booking> getBookingsByUser(Long userId);
    void cancelBooking(Long bookingId);
}

