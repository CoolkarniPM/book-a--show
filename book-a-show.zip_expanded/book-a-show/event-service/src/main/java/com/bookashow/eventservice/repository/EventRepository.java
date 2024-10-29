// event-service/src/main/java/com/bookashow/event/repository/EventRepository.java
package com.bookashow.eventservice.repository;

import com.bookashow.eventservice.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // Additional query methods if needed
}
