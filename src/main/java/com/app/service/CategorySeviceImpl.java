package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.CategoryRepository;
import com.app.dto.CategoryDTO;
import com.app.entities.Category;
@Service 
@Transactional
public class CategorySeviceImpl implements CategoryService {
	@Autowired
	private CategoryRepository catrepo ;
	@Autowired
	private ModelMapper mapper;

	
	@Override
	public CategoryDTO addNewCategory(CategoryDTO dto) {
		Category category=mapper.map(dto, Category.class);
				
		return  mapper.map(catrepo.save(category), CategoryDTO.class);
	}

	@Override
	public List<Category> getAllCategory() {
		return catrepo.findAll();
	}

	@Override
	public String deleteCatDetails(Long catId) {
		if(catrepo.existsById(catId))
		{
			catrepo.deleteById(catId);
			return "delete category suceessfull";
		}
		throw new ResourceNotFoundException("Emp details can't be deleted : Invalid Emp Id!!!");
	}

}
