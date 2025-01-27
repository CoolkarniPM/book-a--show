package com.bookingmanagement.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookingmanagement.entity.Payment;


@FeignClient(name = "payment-service", url = "http://localhost:8083/payments")
public interface PaymentClient {

    @PostMapping
    Payment processPayment(@RequestParam Long bookingId, @RequestParam Long userId, @RequestParam double amount);
}

