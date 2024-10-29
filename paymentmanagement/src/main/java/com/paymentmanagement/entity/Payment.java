package com.paymentmanagement.entity;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data

public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long bookingId; // Corresponding booking ID

    @Column(nullable = false)
    private Long userId; // ID of the user making the payment

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private String paymentStatus; // SUCCESS, FAILED, PENDING

    @Column(nullable = false)
    private LocalDateTime paymentTime;

	public Payment() {
		super();
	}

	public Payment(Long id, Long bookingId, Long userId, double amount, String paymentStatus,
			LocalDateTime paymentTime) {
		super();
		this.id = id;
		this.bookingId = bookingId;
		this.userId = userId;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
		this.paymentTime = paymentTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public LocalDateTime getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(LocalDateTime paymentTime) {
		this.paymentTime = paymentTime;
	}
    
	
    
}
