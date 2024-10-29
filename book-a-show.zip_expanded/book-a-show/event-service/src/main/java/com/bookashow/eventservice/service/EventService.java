// event-service/src/main/java/com/bookashow/event/service/EventService.java
package com.bookashow.eventservice.service;

import com.bookashow.eventservice.model.Event;
import com.bookashow.eventservice.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    
    @Autowired
    private EventRepository eventRepository;

    public Event createEvent(Event event){
        event.setAvailableTickets(event.getTotalTickets());
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Long id){
        return eventRepository.findById(id);
    }

    public Event updateEvent(Long id, Event eventDetails){
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        event.setName(eventDetails.getName());
        event.setType(eventDetails.getType());
        event.setDescription(eventDetails.getDescription());
        event.setLocation(eventDetails.getLocation());
        event.setDateTime(eventDetails.getDateTime());
        event.setTotalTickets(eventDetails.getTotalTickets());
        event.setAvailableTickets(eventDetails.getAvailableTickets());
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id){
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        eventRepository.delete(event);
    }
}
