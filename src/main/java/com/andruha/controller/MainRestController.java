package com.andruha.controller;

import com.andruha.model.entity.Book;
import com.andruha.model.entity.Genre;
import com.andruha.repository.ImgPdfBRepository;
import com.andruha.service.implementations.GenreServiceImpl;
import com.andruha.service.implementations.PublisherServiceImpl;
import com.andruha.service.interfaces.AuthorService;
import com.andruha.service.interfaces.BookService;
import com.andruha.service.interfaces.ImgPdfBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private ImgPdfBService imgPdfBService;

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
    public void setImgPdfBService(ImgPdfBService imgPdfBService) {
        this.imgPdfBService = imgPdfBService;
    }


    /**
     * It downloads all books from DB.
     * @return
     */
    @RequestMapping(value = "/getAll")
    public List<Book> getAll(){
        return bookService.getAllBooks();
    }

    /**
     * It downloads list of books by genre id.
     * @param id
     * @return
     */
    @RequestMapping(value = "/getBooksByGenreId/{id}")
    public List<Book> getBooksByGenreId(@PathVariable long id){
        return bookService.getBooksByGenreId(id);
    }

    /**
     * It downloads list of books which starts from the letter(param) letter.
     * @param letter
     * @return
     */
    @RequestMapping(value = "/getBooksByLetter/{letter}")
    public List<Book> getBooksByLetter(@PathVariable String letter){return bookService.getBooksLetter(letter);}

    /**
     * It downloads list of books which contains string(param name) in book name.
     * @param name
     * @return
     */
    @RequestMapping(value = "/getBooksByName/{name}")
    public List<Book> getBooksByName(@PathVariable String name){
        List<Book> list =  bookService.getBooksByName(name);
        return list;
    }

    /**
     * It downloads a book by its id.
     * @param id
     * @return
     */
    @RequestMapping(value = "/getBookById/{id}")
    public Book getBookById(@PathVariable long id){
        return bookService.getBookById(id);
    }

    /**
     * It downloads an image by book id.
     * @param id
     * @return
     */
    @RequestMapping(value = "/getBookImageById/{id}")
    public byte[] getBookImageById(@PathVariable long id){
        return imgPdfBService.getImageByBookId(id);
    }

    /**
     * It downloads publisher name by its id.
     * @param id
     * @return
     */
    @RequestMapping(value = "/getPublisherName/{id}")
    public String getPublisherName(@PathVariable long id){
        return publisherService.getPublisherNameById(id);
    }

    /**
     * It downloads author name by its id.
     * @param id
     * @return
     */
    @RequestMapping(value = "/getAuthorName/{id}")
    public String getAuthorName(@PathVariable long id){
        return authorService.getNameById(id);
    }

    /**
     * It downloads list of all genres.
     * @return
     */
    @RequestMapping(value = "/getAllGenres")
    public List<Genre> getAllGenres(){
        return genreService.getAllGenre();
    }

    /**
     * It downloads name of genre by its id.
     * @param id
     * @return
     */
    @RequestMapping(value = "/getAllGenres/{id}")
    public String getGenreName(@PathVariable long id){
        return genreService.getGenreNameById(id);
    }
}
