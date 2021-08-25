package com.libraryManagement.Library.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String Shelves;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShelves() {
		return Shelves;
	}

	public void setShelves(String shelves) {
		Shelves = shelves;
	}

	public Book(Long id, String name, String shelves) {
		super();
		this.id = id;
		this.name = name;
		Shelves = shelves;
	}

}
