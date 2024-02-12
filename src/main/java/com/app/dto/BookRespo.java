package com.app.dto;

public class BookRespo {
    private int id;
    private String isbn;
    private String title;
    private double price;
    private String available;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	public BookRespo(int id, String isbn, String title, double price, String available) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.available = available;
	}
	public BookRespo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BookRespo [id=" + id + ", isbn=" + isbn + ", title=" + title + ", price=" + price + ", available="
				+ available + "]";
	}
	
}
