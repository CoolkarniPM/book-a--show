package com.eventmanagement.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventmanagement.entity.Event;
import com.eventmanagement.entity.Show;
import com.eventmanagement.repo.EventRepository;
import com.eventmanagement.repo.ShowRepository;
import com.eventmanagement.service.ShowService;

import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Show createShow(Long eventId, Show show) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        show.setEvent(event);
        return showRepository.save(show);
    }

    @Override
    public Show updateShow(Long showId, Show showDetails) {
        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show not found"));

        show.setStartTime(showDetails.getStartTime());
        show.setEndTime(showDetails.getEndTime());
        
        return showRepository.save(show);
    }

    @Override
    public void deleteShow(Long showId) {
        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show not found"));

        showRepository.delete(show);
    }

    @Override
    public Show getShowById(Long showId) {
        return showRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show not found"));
    }

    @Override
    public List<Show> getShowsByEvent(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        return event.getShows();
    }
}
