package com.ticketbooksystem.service;

import java.util.List;
import java.util.Optional;

import com.ticketbooksystem.entity.Event;
import com.ticketbooksystem.entity.Show;

public interface ShowService {
	
	int getAvailableTickets(Long showId);
	
	boolean bookTickets(Long showId, int count);
	
	List<Show> getAllShowByEvent(Long eventId);
	
	
    // Create a new show
    Show createShow(Show show);

    // Retrieve a show by its ID
    Optional<Show> getShowById(Long showId);

    // Retrieve all shows
    List<Show> getAllShows();

    // Update an existing show
    Show updateShow(Long showId, Show showDetails);

    // Delete a show by its ID
    void deleteShow(Long showId);

    
}
