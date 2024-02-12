package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class CategoryDTO {
	//use it during ser n skip it during de-ser	
	@JsonProperty(access = Access.READ_ONLY)
    private Long id;
    private String catName;
    private String description;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public CategoryDTO(Long id, String catName, String description) {
		super();
		this.id = id;
		this.catName = catName;
		this.description = description;
	}
	public CategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
   
    
}