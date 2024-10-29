package com.eventmanagement.service;


import java.util.List;

import com.eventmanagement.entity.Event;

public interface EventService {

    Event createEvent(Event event);

    Event updateEvent(Long eventId, Event eventDetails);

    void deleteEvent(Long eventId);

    Event getEventById(Long eventId);

    List<Event> getAllEvents();
}

