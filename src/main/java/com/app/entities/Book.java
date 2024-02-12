package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "products")
public class Book extends BaseEntity {
	    
	    private String isbn;
	    private String title;
	    private double price;
	    private String available;
	    @ManyToOne
	    @JoinColumn(name="Author_id",nullable = false)
	    private Author author;

	    @ManyToOne
	    @JoinColumn(name="category_id",nullable = false)
	    private Category category;

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

		public Author getAuthor() {
			return author;
		}

		public void setAuthor(Author author) {
			this.author = author;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		public Book(String isbn, String title, double price, String available, Author author, Category category) {
			super();
			this.isbn = isbn;
			this.title = title;
			this.price = price;
			this.available = available;
			this.author = author;
			this.category = category;
		}

		public Book() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Book [isbn=" + isbn + ", title=" + title + ", price=" + price + ", available=" + available
					+ ", author=" + author + ", category=" + category + "]";
		}
	    

	
}
