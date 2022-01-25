package com.bookmyshow.bookmyshow.repository;

import com.bookmyshow.bookmyshow.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
