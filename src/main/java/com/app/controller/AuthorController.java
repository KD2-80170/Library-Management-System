package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.AuthorDTO;
import com.app.entities.Author;
import com.app.service.AuthorService;


@RestController
@RequestMapping("/author")
public class AuthorController {
   @Autowired
   private AuthorService authService;
   
   @PostMapping
	public AuthorDTO ddNewAuthor(@RequestBody AuthorDTO dto)
	{
		System.out.println("in add new category");
		return authService.addNewAuthor(dto);
	}
	@GetMapping
     public List<Author>  getAll()
      {
		return authService.getAllAuth();
       }
   
	@DeleteMapping("/{authId}")
	public ApiResponse deletAuthorDetails(@PathVariable Long authId) {
		System.out.println("in del author dtls " );
		return new ApiResponse(authService.deleteAuthDetails(authId));
	}
}
