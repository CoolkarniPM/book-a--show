// booking-service/src/main/java/com/bookashow/booking/client/EventClient.java
package com.bookashow.booking.client;

import com.bookashow.booking.dto.Event;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
// import java.util.Optional;

@FeignClient(name = "event-service")
public interface EventClient {
    
    @GetMapping("/events/{id}")
    Event getEventById(@PathVariable("id") Long id);

    @PutMapping("/events/{id}")
    Event updateEvent(@PathVariable("id") Long id, @RequestBody Event event);
    
    // Additional methods as needed
}
