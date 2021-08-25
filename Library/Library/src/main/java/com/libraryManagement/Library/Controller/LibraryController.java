package com.libraryManagement.Library.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.libraryManagement.Library.Entity.Book;
import com.libraryManagement.Library.Repository.LibraryRepo;
import com.libraryManagement.Library.Service.LibraryService;

@RestController
public class LibraryController {

	@Autowired
	private LibraryRepo repository;

	@Autowired
	private LibraryService service;

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAll() {
		return new ResponseEntity(repository.findAll(), HttpStatus.OK);
	}

	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		return repository.save(book);
	}

	@GetMapping("/books/{name}")
		public ResponseEntity<List<Book>> getBookByName(@PathVariable String name ) {
			return new ResponseEntity<>repository.findById(service.(name), HttpStatus.OK);
		}
}
