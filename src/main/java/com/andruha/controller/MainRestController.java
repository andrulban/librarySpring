package com.andruha.controller;

import com.andruha.model.entity.Book;
import com.andruha.model.entity.FullBook;
import com.andruha.model.entity.Genre;
import com.andruha.repository.ImgPdfBRepository;
import com.andruha.service.implementations.FullBookServiceImpl;
import com.andruha.service.implementations.GenreServiceImpl;
import com.andruha.service.implementations.PublisherServiceImpl;
import com.andruha.service.interfaces.AuthorService;
import com.andruha.service.interfaces.BookService;
import com.andruha.service.interfaces.FullBookService;
import com.andruha.service.interfaces.ImgPdfBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by andrusha on 19.06.17.
 */

@RestController
public class MainRestController {

    private BookService bookService;
    private AuthorService authorService;
    private GenreServiceImpl genreService;
    private PublisherServiceImpl publisherService;
    private FullBookServiceImpl fullBookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Autowired
    public void setGenreService(GenreServiceImpl genreService) {
        this.genreService = genreService;
    }

    @Autowired
    public void setPublisherService(PublisherServiceImpl publisherService) {
        this.publisherService = publisherService;
    }

    @Autowired
    public void setFullBookService(FullBookServiceImpl fullBookService) {
        this.fullBookService = fullBookService;
    }

    /**
     * It downloads all books from DB.
     * @return
     */
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getAll(){
        return bookService.getAllBooks();
    }

    /**
     * It downloads list of books by genre id.
     * @param id
     * @return
     */
    @RequestMapping(value = "/books/genreId/{id}", method = RequestMethod.GET)
    public List<Book> getBooksByGenreId(@PathVariable long id){
        return bookService.getBooksByGenreId(id);
    }

    /**
     * It downloads list of books which starts from the letter(param) letter.
     * @param letter
     * @return
     */
    @RequestMapping(value = "/books/letter/{letter}", method = RequestMethod.GET)
    public List<Book> getBooksByLetter(@PathVariable String letter){return bookService.getBooksLetter(letter);}

    /**
     * It downloads list of books which contains string(param name) in book name.
     * @param name
     * @return
     */
    @RequestMapping(value = "/books/name/{name}", method = RequestMethod.GET)
    public List<Book> getBooksByName(@PathVariable String name){
        List<Book> list =  bookService.getBooksByName(name);
        return list;
    }

    @RequestMapping(value = "/fullBooks", method = RequestMethod.GET)
    public List<FullBook> getFullAll(){
        return fullBookService.getAll();
    }

    @RequestMapping(value = "/fullBooks/{id}", method = RequestMethod.GET)
    public FullBook getFullBook(@PathVariable Long id){
        return fullBookService.getFullBook(id);
    }

    /**
     * It downloads a book by its id.
     * @param id
     * @return
     */
    @RequestMapping(value = "/books/{id}",method = RequestMethod.GET)
    public Book getBookById(@PathVariable long id){
        return bookService.getBookById(id);
    }

    /**
     * It downloads publisher name by its id.
     * @param id
     * @return
     */
    @RequestMapping(value = "/publisherName/{id}")
    public String getPublisherName(@PathVariable long id){
        return publisherService.getPublisherNameById(id);
    }

    /**
     * It downloads author name by its id.
     * @param id
     * @return
     */
    @RequestMapping(value = "/authorName/{id}")
    public String getAuthorName(@PathVariable long id){
        return authorService.getNameById(id);
    }

    /**
     * It downloads list of all genres.
     * @return
     */
    @RequestMapping(value = "/genres")
    public List<Genre> getAllGenres(){
        return genreService.getAllGenre();
    }
}
