package com.ticketbooksystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbooksystem.entity.Show;
import com.ticketbooksystem.service.ShowService;

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    private ShowService showService;
    

    @GetMapping("/{eventId}")
    public ResponseEntity<List<Show>> getAllShowByEvent(@PathVariable Long eventId){
    	List<Show> shows = this.showService.getAllShowByEvent(eventId);
    	
    	return ResponseEntity.ok(shows);
    }

    @GetMapping("/{id}/availability")
    public int getTicketAvailability(@PathVariable Long id) {
        return showService.getAvailableTickets(id);
    }

    @PutMapping("/{id}/book")
    public ResponseEntity<String> bookTickets(@PathVariable Long id, @RequestParam int count) {
        boolean success = showService.bookTickets(id, count);
        if (success) {
            return ResponseEntity.ok("Tickets booked successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not enough tickets available.");
        }
    }
}
