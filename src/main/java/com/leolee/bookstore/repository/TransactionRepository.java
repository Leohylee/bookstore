package com.leolee.bookstore.repository;

import com.leolee.bookstore.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // CRUD database methods
}
