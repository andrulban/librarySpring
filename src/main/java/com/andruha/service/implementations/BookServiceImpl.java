package com.andruha.service.implementations;

import com.andruha.model.entity.Book;
import com.andruha.repository.BookRepository;
import com.andruha.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by andrusha on 19.06.17.
 */

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getBooksByGenreId(long id) {
        return bookRepository.findAllByGenre_id(id);
    }

    @Override
    public List<Book> getBooksByName(String name) {
        return bookRepository.findBooksByNameContains(name);
    }

    @Override
    public List<Book> getBooksLetter(String letter) {
        return bookRepository.findBooksByNameStartsWith(letter);
    }

    @Override
    public Book getBookById(long id) {
        return bookRepository.getBookById(id);
    }

    @Override
    public void deleteBookById(long id) {
        bookRepository.delete(id);
    }

    @Override
    public void editBookById(long id) {
        //bookRepository
    }

    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
    }
}
