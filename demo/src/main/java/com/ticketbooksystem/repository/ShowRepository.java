package com.ticketbooksystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticketbooksystem.entity.Event;
import com.ticketbooksystem.entity.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

	List<Show> findByEvent(Event event);

	

}