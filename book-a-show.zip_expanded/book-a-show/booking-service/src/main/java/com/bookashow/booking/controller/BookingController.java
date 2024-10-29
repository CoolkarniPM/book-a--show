// booking-service/src/main/java/com/bookashow/booking/controller/BookingController.java
package com.bookashow.booking.controller;

import com.bookashow.booking.model.Booking;
import com.bookashow.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(@Valid @RequestBody Booking booking){
        return ResponseEntity.ok(bookingService.createBooking(booking));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getBookingsByUser(@PathVariable Long userId){
        return ResponseEntity.ok(bookingService.getBookingsByUserId(userId));
    }

    // Additional endpoints as needed
}
