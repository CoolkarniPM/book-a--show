package com.ticketBooking.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketBooking.entity.Event;
import com.ticketBooking.repo.EventRepo;
import com.ticketBooking.service.EventService;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepo eventRepo;

    @Override
    public Event createEvent(Event event) {
        return eventRepo.save(event);
    }

    @Override
    public Event getEventById(Long id) {
        Optional<Event> event = eventRepo.findById(id);
        return event.orElse(null);
    }

    @Override
    public Event updateEvent(Long id, Event eventDetails) {
        Event event = getEventById(id);
        if (event != null) {
            event.setName(eventDetails.getName());
            event.setDate(eventDetails.getDate());
            event.setLocation(eventDetails.getLocation());
            // Set other fields as needed
            return eventRepo.save(event);
        }
        return null;
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepo.deleteById(id);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }
}
