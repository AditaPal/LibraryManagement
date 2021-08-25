package com.libraryManagement.Library.Controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.libraryManagement.Library.Entity.Book;
import com.libraryManagement.Library.Repository.LibraryRepo;

@ExtendWith(SpringExtension.class)
@WebMvcTest(LibraryController.class)
public class LibraryControllertest {

   @Autowired
   private MockMvc mvc;

   @MockBean
   private LibraryController libraryController;
   
   @MockBean
   private LibraryRepo repo;
   
   
   @Test
   public void testAddBook() 
   {
       MockHttpServletRequest request = new MockHttpServletRequest();
       RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
       when(repo.addEmployee(any(Book.class))).thenReturn(true);
        
       Book book = new Book(1, "Java8", "Test");
       ResponseEntity<Object> responseEntity = libraryController.add(book);
        
       assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
       assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
   }
   @Test
   public void testFindAll() 
   {
       // given
	   Book book1 = new Book(1L, "Python", "One");
	   Book book2 = new Book(2L, "SQL", "Two");
	   Book book3 = new Book(3L , "Devopps" , "Three");
	  List<Book> booklist = new ArrayList();
	  booklist.add(book3);
	  booklist.add(book1);
	  booklist.add(book2);

       when(repo.findAll()).thenReturn(booklist);

       // when
       booklist result = libraryController.getAll();

       // then
       assertThat(result.size()).isEqualTo(3);
        
       assertThat(result.getEmployeeList().get(0).getName())
                       .isEqualTo(book1.getName());
       assertThat(result.getEmployeeList().get(0).getName())
       .isEqualTo(book2.getName());
   }
}

