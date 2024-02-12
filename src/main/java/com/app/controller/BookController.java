package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.BookDTO;
import com.app.dto.BookRespo;
import com.app.entities.Book;
import com.app.service.BookService;


@RestController
@RequestMapping("/books")
public class BookController {
  @Autowired
  private BookService bookservice;
   //REST API end point
	// URL : http://localhost:8080/employees/
	// Method : GET
	// resp : List<EmpDTO>
       @GetMapping
        List<Book> getAllBook()
      {
    	  return bookservice.getAllbook();
      }
	
       @PostMapping
        public BookRespo addBook(BookDTO dto)
        {
        	System.out.println("book addd succesfull");
        	return bookservice.addnewBook(dto);
        }
       
       @DeleteMapping("/{bookId}") 
       public ApiResponse deleteBookDetails(@PathVariable Long bookId) {
   		System.out.println("in del emp dtls " + bookId);
   		return new ApiResponse(bookservice.deleteEmpDetails(bookId));
   	}
       
       @GetMapping("/search")
       public List<Book> searchBooks(@RequestParam("name") String name) {
           return bookservice.searchBooksByName(name);
       }
       
       @PutMapping("/{bookId}")
       public BookRespo updateBook(@PathVariable Long bookId, @RequestBody BookDTO Dto) {
			/*
			 * BookDto updatedBook = bookService.updateBook(id, bookDto); if (updatedBook !=
			 * null) { return ResponseEntity.ok(updatedBook); } return
			 * ResponseEntity.notFound().build(); }
			 */
    	   return bookservice.updatebook(bookId,Dto);
   }
}
