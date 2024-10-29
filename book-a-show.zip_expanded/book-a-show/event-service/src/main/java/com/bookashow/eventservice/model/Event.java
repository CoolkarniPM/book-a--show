// event-service/src/main/java/com/bookashow/event/entity/Event.java
package com.bookashow.eventservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "events")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Event name is mandatory")
    private String name;

    @NotBlank(message = "Event type is mandatory")
    private String type; // e.g., Movie, Concert

    private String description;

    private String location;

    @NotBlank(message = "Date and Time are mandatory")
    private String dateTime; // Consider using LocalDateTime for better handling

    @NotNull(message = "Total tickets are mandatory")
    private Integer totalTickets;

    private Integer availableTickets;
}
