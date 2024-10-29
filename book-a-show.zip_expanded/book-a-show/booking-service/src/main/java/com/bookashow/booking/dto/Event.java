// booking-service/src/main/java/com/bookashow/booking/dto/Event.java
package com.bookashow.booking.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    private Long id;
    private String name;
    private String type;
    private String description;
    private String location;
    private String dateTime;
    private Integer totalTickets;
    private Integer availableTickets;
}
