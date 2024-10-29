package com.ticketbooksystem.service;

import com.ticketbooksystem.entity.Event;
import java.util.List;
import java.util.Optional;

public interface EventService {
    // Create a new event
    Event createEvent(Event event);

    // Retrieve an event by its ID
    Event getEventById(Long eventId);

    // Retrieve all events
    List<Event> getAllEvents();

    // Update an existing event
    Event updateEvent(Long eventId, Event eventDetails);

    // Delete an event
    void deleteEvent(Long eventId);

    // Find events by criteria (e.g., location, date, etc.)
    List<Event> findEventsByCriteria(String criteria);
}
