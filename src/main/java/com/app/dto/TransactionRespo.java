package com.app.dto;

import java.time.LocalDate;

public class TransactionRespo {
	 private Long id;
	 private LocalDate checkoutDate;
	 private LocalDate returnDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	public TransactionRespo(Long id, LocalDate checkoutDate, LocalDate returnDate) {
		super();
		this.id = id;
		this.checkoutDate = checkoutDate;
		this.returnDate = returnDate;
	}
	public TransactionRespo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TransactionRespo [id=" + id + ", checkoutDate=" + checkoutDate + ", returnDate=" + returnDate + "]";
	}
	 
	
}
