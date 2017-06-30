package com.andruha.service.interfaces;

import com.andruha.model.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by andrusha on 19.06.17.
 */
public interface BookService {

    List<Book> getAllBooks();
    List<Book> getBooksByGenreId(long id);
    List<Book> getBooksByName(String name);
    List<Book> getBooksLetter(String letter);
    Book getBookById(long id);
    void deleteBookById(long id);
    void editBookById(Book book);
    void createBook(Book book);

}
