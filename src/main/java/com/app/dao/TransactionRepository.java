package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

}
