package com.ticketBooking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketBooking.entity.Event;

public interface EventRepo extends JpaRepository<Event, Long> {

}
