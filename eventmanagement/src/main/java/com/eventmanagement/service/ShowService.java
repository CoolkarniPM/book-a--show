package com.eventmanagement.service;



import java.util.List;

import com.eventmanagement.entity.Show;

public interface ShowService {

    Show createShow(Long eventId, Show show);

    Show updateShow(Long showId, Show showDetails);

    void deleteShow(Long showId);

    Show getShowById(Long showId);

    List<Show> getShowsByEvent(Long eventId);
}
