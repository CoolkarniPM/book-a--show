package com.paymentmanagement.service;

import java.util.List;

import com.paymentmanagement.entity.Payment;

public interface PaymentService {
    Payment processPayment(Long bookingId, Long userId, double amount);
    Payment getPaymentByBooking(Long bookingId);
}

