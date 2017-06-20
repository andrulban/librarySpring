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

    /**
     * It downloads list of all books.
     * @return
     */
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * It downloads list of books by genre's id.
     * @param id
     * @return
     */
    @Override
    public List<Book> getBooksByGenreId(long id) {
        return bookRepository.findAllByGenre_id(id);
    }

    /**
     * It downloads list of books by string in its name.
     * @param name
     * @return
     */
    @Override
    public List<Book> getBooksByName(String name) {
        return bookRepository.findBooksByNameContains(name);
    }

    /**
     * It downloads list of books by first letter in its name.
     * @param letter
     * @return
     */
    @Override
    public List<Book> getBooksLetter(String letter) {
        return bookRepository.findBooksByNameStartsWith(letter);
    }

    /**
     * It downloads book by its id.
     * @param id
     * @return
     */
    @Override
    public Book getBookById(long id) {
        return bookRepository.getBookById(id);
    }

    /**
     * It deletes book by its id.
     * @param id
     */
    @Override
    public void deleteBookById(long id) {
        bookRepository.delete(id);
    }

    /**
     * It edits book info.
     * @param book
     */
    @Override
    public void editBookById(Book book) {
        Book dbBook = bookRepository.getBookById(book.getId());
        dbBook.setPageCount(book.getPageCount());
        dbBook.setAuthor_id(book.getAuthor_id());
        dbBook.setGenre_id(book.getGenre_id());
        dbBook.setId(book.getId());
        dbBook.setIsbn(book.getIsbn());
        dbBook.setName(book.getName());
        dbBook.setPublisher_id(book.getPublisher_id());
        dbBook.setPublish_year(book.getPublish_year());
        bookRepository.saveAndFlush(dbBook);
    }

    /**
     * It creates new book.
     * @param book
     */
    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
    }
}
