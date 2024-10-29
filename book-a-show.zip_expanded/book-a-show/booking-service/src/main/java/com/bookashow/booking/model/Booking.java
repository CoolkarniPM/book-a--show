// booking-service/src/main/java/com/bookashow/booking/entity/Booking.java
package com.bookashow.booking.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;import lombok.*;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Event ID is mandatory")
    private Long eventId;

    @NotNull(message = "User ID is mandatory")
    private Long userId;

    @NotNull(message = "Number of tickets is mandatory")
    private Integer numberOfTickets;

    private String bookingStatus; // e.g., CONFIRMED, CANCELLED
}
