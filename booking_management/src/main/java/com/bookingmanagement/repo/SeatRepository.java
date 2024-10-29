package com.bookingmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookingmanagement.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
