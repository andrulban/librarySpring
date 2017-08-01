package com.andruha.security_test;

import com.andruha.ForpgsApplication;
import com.andruha.model.entity.Book;
import com.andruha.security_test.annotations.CustomUser;
import com.andruha.service.interfaces.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by andrusha on 01.08.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@CustomUser
public class SecurityMethodTest {

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Test
    public void getAllBooks() {
        bookService.getAllBooks();
    }
    @Test(expected = org.springframework.security.access.AccessDeniedException.class)
    public void deleteBook() {
        bookService.deleteBookById(29);
    }
    @Test(expected = org.springframework.security.access.AccessDeniedException.class)
    public void editBook() {
        bookService.editBookById(new Book());
    }
    @Test(expected = org.springframework.security.access.AccessDeniedException.class)
    public void addBook() {
        bookService.createBook(new Book());
    }
}
