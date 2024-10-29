package com.ticketbooksystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbooksystem.entity.Event;
import com.ticketbooksystem.exception.ResourceNotFoundException;
import com.ticketbooksystem.repository.EventRepository;
import com.ticketbooksystem.service.EventService;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event updatedEvent) {
        Event event = eventRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
        event.setName(updatedEvent.getName());
        event.setType(updatedEvent.getType());
        event.setDate(updatedEvent.getDate());
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

	public Event getEventById(Long id) {
		
		Event event = eventRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
		return event;
	}

	@Override
	public List<Event> findEventsByCriteria(String criteria) {
		// TODO Auto-generated method stub
		return null;
	}
}

