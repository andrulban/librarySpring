package com.andruha.service_test;

import com.andruha.model.entity.Book;
import com.andruha.service.interfaces.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;


/**
 * Created by andrusha on 20.06.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Test
    public void editBookServiceTest(){
        List<Book> list = bookService.getAllBooks();
        Book book = list.get(0);
        String name = book.getName();
        book.setName("Vvvv");
        bookService.editBookById(book);
        Book sameBook = bookService.getBookById(book.getId());
        assertEquals(book.getName(),sameBook.getName());
        book.setName(name);
        bookService.editBookById(book);
    }

    @Test
    public void deleteBookServiceTest(){
        List<Book> list = bookService.getAllBooks();
        Book book = list.get(0);
        bookService.deleteBookById(book.getId());
        assertNull(bookService.getBookById(book.getId()));
        bookService.createBook(book);
    }

    @Test
    public void bookServiceTest0(){
        List<Book> list = bookService.getAllBooks();
        Book book = list.get(0);
        assertNotNull(book);
    }

    @Test
    public void bookServiceTest1(){
        Book book = bookService.getBookById(0);
        assertNull(book);
    }

    @Test
    public void bookServiceTest2(){
        List<Book> list = bookService.getAllBooks();
        Book book = list.get(0);
        List<Book> sameList = bookService.getAllBooks();
        Book sameBook = sameList.get(0);
        assertEquals(book,book);
        assertEquals(sameBook,sameBook);
        assertEquals(book,sameBook);
    }

    @Test
    public void bookServiceTest3(){
        List<Book> list = bookService.getAllBooks();
        Book book = list.get(0);
        Book anotherBook = list.get(1);
        assertNotEquals(book,anotherBook);
    }


}
