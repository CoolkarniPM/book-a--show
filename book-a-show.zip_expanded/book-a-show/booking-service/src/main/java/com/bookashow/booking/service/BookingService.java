// booking-service/src/main/java/com/bookashow/booking/service/BookingService.java
package com.bookashow.booking.service;

import com.bookashow.booking.dto.Event;
import com.bookashow.booking.model.Booking;
import com.bookashow.booking.repository.BookingRepository;
import com.bookashow.booking.client.EventClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class BookingService {
    
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private EventClient eventClient;

    @Transactional
    public Booking createBooking(Booking booking){
        // Check event availability
        Event event = eventClient.getEventById(booking.getEventId());
        if(event.getAvailableTickets() < booking.getNumberOfTickets()){
            throw new RuntimeException("Not enough tickets available");
        }

        // Deduct available tickets
        event.setAvailableTickets(event.getAvailableTickets() - booking.getNumberOfTickets());
        eventClient.updateEvent(event.getId(), event);

        booking.setBookingStatus("CONFIRMED");
        return bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByUserId(Long userId){
        return bookingRepository.findByUserId(userId);
    }

    // Additional methods as needed
}
