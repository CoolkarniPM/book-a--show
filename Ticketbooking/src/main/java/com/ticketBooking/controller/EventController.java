package com.ticketBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticketBooking.entity.Event;
import com.ticketBooking.service.EventService;

@RestController
@RequestMapping("/api/events")
public class EventController {
	
    @Autowired
    private EventService eventService;

    @GetMapping("/")
    public List<Event> getAllEvents() {
        return  this.eventService.getAllEvents();
    }

    @PostMapping("/")
    public Event createEvent(@RequestBody Event event) {
        return this.eventService.createEvent(event);
    }

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event eventDetails) {
        return this.eventService.updateEvent(id, eventDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long id) {
        this.eventService.deleteEvent(id);
        return ResponseEntity.ok().build();
    }
}

