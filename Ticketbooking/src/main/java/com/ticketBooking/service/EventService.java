package com.ticketBooking.service;

import java.util.List;

import com.ticketBooking.entity.Event;

public interface EventService {

    // Method to create a new event
    public Event createEvent(Event event);

    // Method to get an event by its ID
    public Event getEventById(Long id);

    // Method to update an existing event
    public Event updateEvent(Long id, Event event);

    // Method to delete an event by its ID
    public void deleteEvent(Long id);

    // Method to get all events
    public List<Event> getAllEvents();
}
