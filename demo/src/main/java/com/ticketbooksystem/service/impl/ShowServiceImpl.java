package com.ticketbooksystem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbooksystem.entity.Event;
import com.ticketbooksystem.entity.Show;
import com.ticketbooksystem.exception.ResourceNotFoundException;
import com.ticketbooksystem.repository.EventRepository;
import com.ticketbooksystem.repository.ShowRepository;
import com.ticketbooksystem.service.ShowService;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowRepository showRepository;
    
    @Autowired
    private EventRepository eventRepo;
    
    @Override
    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    @Override
    public int getAvailableTickets(Long showId) {
        Show show = showRepository.findById(showId)
            .orElseThrow(() -> new ResourceNotFoundException("Show not found"));
        return show.getAvailableTickets();
    }

    @Override
    public boolean bookTickets(Long showId, int count) {
        Show show = showRepository.findById(showId)
            .orElseThrow(() -> new ResourceNotFoundException("Show not found"));
        if (show.getAvailableTickets() >= count) {
            show.setAvailableTickets(show.getAvailableTickets() - count);
            showRepository.save(show);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Show createShow(Show show) {
        return showRepository.save(show);
    }

    @Override
    public Optional<Show> getShowById(Long showId) {
        return showRepository.findById(showId);
    }

    @Override
    public Show updateShow(Long showId, Show showDetails) {
        Show show = showRepository.findById(showId)
            .orElseThrow(() -> new ResourceNotFoundException("Show not found"));
        show.setAvailableTickets(showDetails.getAvailableTickets());
        show.setStartTime(showDetails.getStartTime());
        // Update any other necessary fields
        return showRepository.save(show);
    }

    @Override
    public void deleteShow(Long showId) {
        Show show = showRepository.findById(showId)
            .orElseThrow(() -> new ResourceNotFoundException("Show not found"));
        showRepository.delete(show);
    }

  

    @Override
    public List<Show> getAllShowByEvent(Long eventId) {
        Event event = eventRepo.findById(eventId)
            .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
        return showRepository.findByEvent(event);
    }

	
}
