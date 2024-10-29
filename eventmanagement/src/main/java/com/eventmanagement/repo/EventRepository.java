package com.eventmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventmanagement.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // Add custom queries if needed
}
