package com.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.TransactionDTO;
import com.app.dto.TransactionRespo;
import com.app.entities.Transaction;
import com.app.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController
{
	@Autowired
	private TransactionService tansservice;
  
	@PostMapping
	
	
	
	
	@DeleteMapping("/{transId}") 
    public ApiResponse deleteTransDetails(@PathVariable Long transId) {
		System.out.println("in del emp dtls " + transId);
		return new ApiResponse(tansservice.deleteTransDetails(transId));
	}
    

	@GetMapping
	public List<Transaction> getAllTransaction()
	{
		System.out.println("transaction is successfull");
		return tansservice.getAllTransaction();
		
	}

	
}
