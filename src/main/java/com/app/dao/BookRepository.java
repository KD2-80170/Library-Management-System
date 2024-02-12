package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Book;

public interface BookRepository extends JpaRepository<Book,Long>{

	List<Book> findByTitleContainingIgnoreCase(String name);

}
