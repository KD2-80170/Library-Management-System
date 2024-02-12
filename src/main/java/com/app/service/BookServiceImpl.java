package com.app.service;
import com.app.custom_exceptions.*;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AuthorRepository;
import com.app.dao.BookRepository;
import com.app.dao.CategoryRepository;
import com.app.dto.BookDTO;
import com.app.dto.BookRespo;
import com.app.entities.Author;
import com.app.entities.Book;
import com.app.entities.Category;
@Service
@Transactional
public class BookServiceImpl implements BookService {
	
   @Autowired
	private BookRepository bookrepo;
   
   @Autowired
   private AuthorRepository authrepo;
   
   @Autowired
   private CategoryRepository catrepo;
  
   @Autowired
   private ModelMapper mapper;
   
  
	@Override
	public List<Book> getAllbook() {
		// TODO Auto-generated method stub
		return bookrepo.findAll()  ;
	}

	@Override
	public BookRespo addnewBook(BookDTO dto) {
		//get category  name by  id get by  dto
	    Category category=catrepo.findById(dto.getCategoryId())
	    	.orElseThrow(()-> new ResourceNotFoundException("invalid cat id"));
	    //get author  name by id that get by dto
	    Author author =authrepo.findById(dto.getAuthorId())
	    		.orElseThrow(()->new ResourceNotFoundException("invalid author id"));
	    //convert dto to class
	   Book book =mapper.map(dto,Book.class);
	     //set author to book 
	   book.setAuthor(author);
	   //set category to book 
	   book.setCategory(category);
	   
	    	return mapper.map(bookrepo.save(book),BookRespo.class);
	}

	@Override
	public String deleteEmpDetails(Long bookId) {
		if(bookrepo.existsById(bookId))
		{
			bookrepo.deleteById(bookId);
		
			return "book isd is not coorect";
		}
	
         throw new  ResourceNotFoundException(" book id is not correct");
         }

	@Override
	public List<Book> searchBooksByName(String name) {
	
		        return bookrepo.findByTitleContainingIgnoreCase(name);
		    }

	@Override
	public BookRespo updatebook(Long bookId, BookDTO dto) {
		Book bookexist=bookrepo.findById(bookId).orElseThrow(()->new  ResourceNotFoundException("invalid book id")) ;
	
			 Category category=catrepo.findById(dto.getCategoryId())
				    	.orElseThrow(()-> new ResourceNotFoundException("invalid cat id"));
			 
			 Author author =authrepo.findById(dto.getAuthorId())
			    		.orElseThrow(()->new ResourceNotFoundException("invalid author id"));
			 
			 Book book =mapper.map(dto,Book.class);
		     //set author to book 
		   book.setAuthor(author);
		   //set category to book 
		   book.setCategory(category);
		   
		
		return mapper.map(bookrepo.save(book),BookRespo.class);
	}
	
	

}
