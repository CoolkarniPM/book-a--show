package com.ticketbooksystem.entity;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "`show`")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime startTime;
    private int availableTickets;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false) // Nullable = false if an Event is required
    private Event event;

    @ManyToOne
    @JoinColumn(name = "movie_hall_id", nullable = false) // Nullable = false if a MovieHall is required
    private MovieHall movieHall;

    // No-argument constructor (required by JPA)
    public Show() {
        super();
    }

    // Constructor without the ID, as it is auto-generated
    public Show(LocalTime startTime, int availableTickets, Event event, MovieHall movieHall) {
        this.startTime = startTime;
        this.availableTickets = availableTickets;
        this.event = event;
        this.movieHall = movieHall;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(int availableTickets) {
        this.availableTickets = availableTickets;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public MovieHall getMovieHall() {
        return movieHall;
    }

    public void setMovieHall(MovieHall movieHall) {
        this.movieHall = movieHall;
    }
}
