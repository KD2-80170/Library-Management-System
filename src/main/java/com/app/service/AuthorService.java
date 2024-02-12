package com.app.service;

import java.util.List;

import com.app.dto.AuthorDTO;
import com.app.entities.Author;

public interface AuthorService {

	AuthorDTO addNewAuthor(AuthorDTO dto);

	List<Author> getAllAuth();

	String deleteAuthDetails(Long authId);

}
