package com.paymentmanagement.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.paymentmanagement.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findByBookingId(Long bookingId);
}

