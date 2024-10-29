package com.eventmanagement.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eventmanagement.entity.Show;
import com.eventmanagement.service.ShowService;

import java.util.List;

@RestController
@RequestMapping("/api/shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/events/{eventId}")
    public ResponseEntity<Show> createShow(@PathVariable Long eventId, @RequestBody Show show) {
        return ResponseEntity.ok(showService.createShow(eventId, show));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Show> updateShow(@PathVariable Long id, @RequestBody Show showDetails) {
        return ResponseEntity.ok(showService.updateShow(id, showDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShow(@PathVariable Long id) {
        showService.deleteShow(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable Long id) {
        return ResponseEntity.ok(showService.getShowById(id));
    }

    @GetMapping("/events/{eventId}")
    public ResponseEntity<List<Show>> getShowsByEvent(@PathVariable Long eventId) {
        return ResponseEntity.ok(showService.getShowsByEvent(eventId));
    }
}

