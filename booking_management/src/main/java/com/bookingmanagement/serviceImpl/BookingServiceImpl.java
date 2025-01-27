package com.bookingmanagement.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingmanagement.entity.Booking;
import com.bookingmanagement.entity.Payment;
import com.bookingmanagement.entity.Seat;
import com.bookingmanagement.repo.BookingRepository;
import com.bookingmanagement.repo.SeatRepository;
import com.bookingmanagement.service.BookingService;
import com.bookingmanagement.service.PaymentClient;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private PaymentClient paymentClient;

    @Override
    public Booking createBooking(Long userId, Long showId, int numberOfSeats, List<String> seatNumbers) {
        // Create a new Booking object and set its properties
        Booking booking = new Booking();
        booking.setUserId(userId);
        booking.setShowId(showId);
        booking.setBookingTime(LocalDateTime.now());
        booking.setNumberOfSeats(numberOfSeats);
        booking.setTotalPrice(calculatePrice(numberOfSeats));
        booking.setStatus("PENDING");

        // Save the booking first to get the ID
        booking = bookingRepository.save(booking);
        
        List<Seat> seats = new ArrayList<>();
        for (String seatNumber : seatNumbers) {
            Seat seat = new Seat();
            seat.setSeatNumber(seatNumber);
            seat.setBooking(booking); // Associate the seat with the booking
            seat.setBooked(true); // Mark the seat as booked
            seats.add(seat);
            seatRepository.save(seat); // Save each seat
        }
        booking.setSeats(seats); // Set the booked seats to the booking

        // Trigger payment
        Payment payment = paymentClient.processPayment(booking.getId(), userId, booking.getTotalPrice());
        
        // Update booking status based on payment status
        if ("SUCCESS".equals(payment.getPaymentStatus())) {
            booking.setStatus("CONFIRMED");
        } else {
            booking.setStatus("FAILED");
            // Optionally: rollback seat booking if payment fails
            for (Seat seat : seats) {
                seatRepository.delete(seat); // Remove booked seats if payment fails
            }
        }

        // Save updated booking status
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getBookingsByUser(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    @Override
    public void cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
            .orElseThrow(() -> new RuntimeException("Booking not found"));
        
        // Optionally release the reserved seats if booking is cancelled
        for (Seat seat : booking.getSeats()) {
            seatRepository.delete(seat); // Remove seats associated with the booking
        }

        booking.setStatus("CANCELLED");
        bookingRepository.save(booking);
    }

    private double calculatePrice(int numberOfSeats) {
        // Price calculation logic can go here
        return numberOfSeats * 10.0; // Example: $10 per seat
    }
}
