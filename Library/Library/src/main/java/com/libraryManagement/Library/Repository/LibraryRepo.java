package com.libraryManagement.Library.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.libraryManagement.Library.Entity.Book;

@Repository
public interface LibraryRepo extends CrudRepository<Book, Long>  {

}
