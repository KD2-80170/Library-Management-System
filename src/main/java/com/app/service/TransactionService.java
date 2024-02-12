package com.app.service;

import java.util.List;

import com.app.dto.TransactionDTO;
import com.app.dto.TransactionRespo;
import com.app.entities.Transaction;

public interface TransactionService {

	

	TransactionRespo addTransaction(TransactionDTO dto);

	String deleteTransDetails(Long transId);

	List<Transaction> getAllTransaction();
    
}
