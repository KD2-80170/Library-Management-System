package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class AuthorDTO {
	@JsonProperty(access = Access.READ_ONLY)
    private Long id;
    private String firstName;
    private String lastName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "AuthorDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	public AuthorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuthorDTO(Long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
    // Getters and setters
}