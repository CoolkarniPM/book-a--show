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
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String transactionId; // Transaction ID from payment gateway

    @Column(nullable = false)
    private Long paymentId; // Corresponding payment ID

    @Column(nullable = false)
    private String transactionStatus; // SUCCESS, FAILURE

    @Column(nullable = false)
    private String paymentGateway; // Gateway name (e.g., Stripe, PayPal)

    @Column(nullable = false)
    private LocalDateTime transactionTime;

	public Transaction() {
		super();
	}

	public Transaction(Long id, String transactionId, Long paymentId, String transactionStatus, String paymentGateway,
			LocalDateTime transactionTime) {
		super();
		this.id = id;
		this.transactionId = transactionId;
		this.paymentId = paymentId;
		this.transactionStatus = transactionStatus;
		this.paymentGateway = paymentGateway;
		this.transactionTime = transactionTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getPaymentGateway() {
		return paymentGateway;
	}

	public void setPaymentGateway(String paymentGateway) {
		this.paymentGateway = paymentGateway;
	}

	public LocalDateTime getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(LocalDateTime transactionTime) {
		this.transactionTime = transactionTime;
	}
    
    
}
