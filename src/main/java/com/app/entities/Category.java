package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category  extends BaseEntity{
	
	@Column(length = 30, unique = true)
	private String catName;
    private String description;
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
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(String catName, String description) {
		super();
		this.catName = catName;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Category [catName=" + catName + ", description=" + description + "]";
	}
    
}
