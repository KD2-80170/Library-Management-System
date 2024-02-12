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
import com.app.dto.CategoryDTO;
import com.app.entities.Category;
import com.app.service.CategoryService;



@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService catservice;
	
	

	   @PostMapping
		public CategoryDTO ddNewCategory(@RequestBody CategoryDTO dto)
		{
			System.out.println("in add new category");
			return catservice.addNewCategory(dto);
		}
		@GetMapping
	   public List<Category>  getAll()
	   {
			return catservice.getAllCategory();
	   }
	   
		@DeleteMapping("/{catId}")
		public ApiResponse deletCategoryDetails(@PathVariable Long catId) {
			System.out.println("in del author dtls " );
			return new ApiResponse(catservice.deleteCatDetails(catId));
		}
}
