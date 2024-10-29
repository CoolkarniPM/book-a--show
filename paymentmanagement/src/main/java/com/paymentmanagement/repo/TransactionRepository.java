package com.paymentmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paymentmanagement.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}

