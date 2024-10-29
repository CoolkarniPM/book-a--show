package com.bookingmanagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookingmanagement.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserId(Long userId); // For fetching user's booking history
}
