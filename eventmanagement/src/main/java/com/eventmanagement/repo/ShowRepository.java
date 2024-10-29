package com.eventmanagement.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventmanagement.entity.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    // Add custom queries if needed
}

