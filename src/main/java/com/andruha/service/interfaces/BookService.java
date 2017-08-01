package com.andruha.service.interfaces;

import com.andruha.model.entity.Book;
import org.springframework.security.access.prepost.PreAuthorize;
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
//    @PreAuthorize("hasRole('ADMIN')")
    void deleteBookById(long id);
//    @PreAuthorize("hasRole('ADMIN')")
    void editBookById(Book book);
//    @PreAuthorize("hasRole('ADMIN')")
    void createBook(Book book);

}
