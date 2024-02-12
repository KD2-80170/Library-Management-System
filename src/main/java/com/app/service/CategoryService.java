package com.app.service;

import java.util.List;

import com.app.dto.CategoryDTO;
import com.app.entities.Category;

public interface CategoryService {

	CategoryDTO addNewCategory(CategoryDTO dto);

	List<Category> getAllCategory();

	String deleteCatDetails(Long catId);

}
