package com.andruha.controller;

import com.andruha.model.entity.FullBook;
import com.andruha.service.interfaces.BookService;
import com.andruha.service.interfaces.FullBookService;
import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.andruha.model.entity.Book;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andrusha on 20.06.17.
 */
@Controller
public class AddEditDeleteBookController {
    private BookService bookService;
    private FullBookService fullBookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    public void setFullBookService(FullBookService fullBookService) {
        this.fullBookService = fullBookService;
    }

    /**
     * Method which redirects to html where book is edited.
     *
     * @return
     */
    @RequestMapping(value = "/bookEdition", method = RequestMethod.GET)
    public String editBookPage() {
        return "pages/editBook.html";
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public void editBook(@RequestBody FullBook fullBook, HttpServletResponse response) {
        fullBookService.editFullBook(fullBook);
        try {
            response.sendRedirect("/main");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    /**
//     * Method which edits selected book and redirects back to index again.
//     * @param name
//     * @param authorId
//     * @param content
//     * @param image
//     * @param genreId
//     * @param publisherId
//     * @param pageCount
//     * @param publishYear
//     * @param isbn
//     * @param response
//     * @return
//     */
//    @RequestMapping(value = "/booksEdit", method = RequestMethod.POST)
//    public void editBook(@RequestParam(name = "name") String name, @RequestParam(name = "author_id") long authorId,
//                           @RequestParam (name = "content") MultipartFile content, @RequestParam(name = "image") MultipartFile image,
//                           @RequestParam(name = "genre_id") long genreId , @RequestParam(name = "publisher_id") long publisherId,
//                           @RequestParam(name = "pageCount") int pageCount, @RequestParam(name = "publishYear") int publishYear,
//                           @RequestParam(name = "isbn") String isbn, @RequestParam(name = "id") Long id,
//                         HttpServletResponse response) {
//
//        try {
//            FullBook fullBook = new FullBook();
//            fullBook.setId(id);
//            fullBook.setAuthor_id(authorId);
//            fullBook.setGenre_id(genreId);
//            fullBook.setPublisher_id(publisherId);
//
//            fullBook.setIsbn(isbn);
//            fullBook.setName(name);
//            fullBook.setPageCount(pageCount);
//            fullBook.setPublishYear(publishYear);
//            fullBook.setContent(content.getBytes());
//            fullBook.setImage(image.getBytes());
//            fullBookService.editFullBook(fullBook);
//        }
//        catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        try {
//            response.sendRedirect("/main");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * Method which redirects to html where book is added.
     *
     * @return
     */
    @RequestMapping(value = "/bookAdding", method = RequestMethod.GET)
    public String addBookPage() {
        return "pages/addBook.html";
    }

    @RequestMapping(value = "/books", method = RequestMethod.PUT)
    public void addBook(@RequestBody FullBook fullBook, HttpServletResponse response) {

        fullBookService.createFullBook(fullBook);
        try {
            response.sendRedirect("/main");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @RequestMapping(value = "/books", method = RequestMethod.PUT)
//    public void  addBook(@RequestParam(name = "name") String name, @RequestParam(name = "author_id") long authorId,
//                           @RequestParam (name = "content") MultipartFile content, @RequestParam(name = "image") MultipartFile image,
//                           @RequestParam(name = "genre_id") long genreId , @RequestParam(name = "publisher_id") long publisherId,
//                           @RequestParam(name = "pageCount") int pageCount, @RequestParam(name = "publishYear") int publishYear,
//                           @RequestParam(name = "isbn") String isbn, HttpServletResponse response) {
//        try {
//            FullBook fullBook = new FullBook();
//            fullBook.setAuthor_id(authorId);
//            fullBook.setGenre_id(genreId);
//            fullBook.setPublisher_id(publisherId);
//
//            fullBook.setIsbn(isbn);
//            fullBook.setName(name);
//            fullBook.setPageCount(pageCount);
//            fullBook.setPublishYear(publishYear);
//            fullBook.setContent(content.getBytes());
//            fullBook.setImage(image.getBytes());
//            fullBookService.createFullBook(fullBook);
//        }
//        catch (IOException ex) {
//            ex.printStackTrace();
//        }
//
//
//        try {
//            response.sendRedirect("/main");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * Method which deletes book by id and redirects back to index again.
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public String deleteBookById(@PathVariable long id) {
        bookService.deleteBookById(id);
        return "index.html";
    }


}
