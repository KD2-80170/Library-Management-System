package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.AuthorRepository;
import com.app.dto.AuthorDTO;
import com.app.entities.Author;
@Service
@Transactional
public class AuthorSeviceImpl implements AuthorService{
	
	@Autowired
	private AuthorRepository  authrepo;
	@Autowired
	private ModelMapper mapper;

	
	@Override
	public AuthorDTO addNewAuthor(AuthorDTO dto) {
		//convert dto to normal class
		Author author = mapper.map(dto, Author.class);
		// save the category n then map persistent entity (with id) --> dto
		return mapper.map(authrepo.save(author), AuthorDTO.class);
	}


	@Override
	public List<Author> getAllAuth() {
		// TODO Auto-generated method stub
		return authrepo.findAll();
	}


	@Override
	public String deleteAuthDetails(Long authId) {
		if(authrepo.existsById(authId))
		{authrepo.deleteById(authId);
		return "deleted emp detail";
		}
		throw new ResourceNotFoundException("Emp details can't be deleted : Invalid Emp Id!!!");
	}
	

}
