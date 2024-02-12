package com.app.service;

import java.util.List;

import com.app.dto.BookDTO;
import com.app.dto.BookRespo;
import com.app.entities.Book;

public interface BookService {

	List<Book> getAllbook();

	BookRespo addnewBook(BookDTO dto);

	String deleteEmpDetails(Long bookId);

	List<Book> searchBooksByName(String name);

	BookRespo updatebook(Long bookId, BookDTO dto);

}
