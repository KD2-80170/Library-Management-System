package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class Author extends BaseEntity {
	   @Column(length = 30, unique = true)
	    private String firstName;
	    private String lastName;
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
		public Author(String firstName, String lastName) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
		}
		public Author() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Author [firstName=" + firstName + ", lastName=" + lastName + "]";
		}
       
}
