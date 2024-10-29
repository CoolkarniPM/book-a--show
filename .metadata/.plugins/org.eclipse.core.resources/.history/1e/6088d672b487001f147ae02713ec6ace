package com.paymentmanagement.serviceImpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentmanagement.entity.Payment;
import com.paymentmanagement.entity.Transaction;
import com.paymentmanagement.repo.PaymentRepository;
import com.paymentmanagement.repo.TransactionRepository;
import com.paymentmanagement.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Payment processPayment(Long bookingId, Long userId, double amount) {
        // Mock payment processing logic

        Payment payment = new Payment();
        payment.setBookingId(bookingId);
        payment.setUserId(userId);
        payment.setAmount(amount);
        payment.setPaymentStatus("SUCCESS");
        payment.setPaymentTime(LocalDateTime.now());

        // Save the payment
        payment = paymentRepository.save(payment);

        // Mock transaction (can be replaced with actual payment gateway logic)
        Transaction transaction = new Transaction();
        transaction.setTransactionId("TRANS_" + System.currentTimeMillis()); // Generate mock transaction ID
        transaction.setPaymentId(payment.getId());
        transaction.setTransactionStatus("SUCCESS");
        transaction.setPaymentGateway("MockGateway");
        transaction.setTransactionTime(LocalDateTime.now());

        transactionRepository.save(transaction);

        return payment;
    }

    @Override
    public Payment getPaymentByBooking(Long bookingId) {
        return paymentRepository.findByBookingId(bookingId);
    }
}

