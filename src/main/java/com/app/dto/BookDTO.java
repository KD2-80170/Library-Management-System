package com.app.dto;

public class BookDTO {
    private Long categoryId;
    private Long authorId;
    private String title;
    private String isbn;
    private double price;
	private String  available;
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
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
	@Override
	public String toString() {
		return "BookDTO [categoryId=" + categoryId + ", authorId=" + authorId + ", title=" + title + ", isbn=" + isbn
				+ ", price=" + price + ", available=" + available + "]";
	}
	public BookDTO(Long categoryId, Long authorId, String title, String isbn, double price, String available) {
		super();
		this.categoryId = categoryId;
		this.authorId = authorId;
		this.title = title;
		this.isbn = isbn;
		this.price = price;
		this.available = available;
	}
	public BookDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
     
}
