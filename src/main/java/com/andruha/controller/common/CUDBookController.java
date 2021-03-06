package com.andruha.controller.common;

import com.andruha.model.entity.FullBook;
import com.andruha.service.implementations.GenreServiceImpl;
import com.andruha.service.implementations.PublisherServiceImpl;
import com.andruha.service.interfaces.AuthorService;
import com.andruha.service.interfaces.BookService;
import com.andruha.service.interfaces.FullBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

/**
 * Created by andrusha on 20.06.17.
 */
@Controller
public class CUDBookController {
    private BookService bookService;
    private FullBookService fullBookService;
    private AuthorService authorService;
    private GenreServiceImpl genreService;
    private PublisherServiceImpl publisherService;

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

//    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public void editBook(@RequestBody FullBook fullBook, HttpServletResponse response) {
        fullBook.getPublisher().setId(publisherService.getIdByName(fullBook.getPublisher().getNameP()));
        fullBook.getAuthor().setId(authorService.getIdByName(fullBook.getAuthor().getFio()));
        fullBook.getGenre().setId(authorService.getIdByName(fullBook.getGenre().getNameG()));
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
//            fullBook.setNameG(name);
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

//    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/books", method = RequestMethod.PUT)
    public void addBook(@Valid @RequestBody FullBook fullBook, HttpServletResponse response) {
        fullBook.getPublisher().setId(publisherService.getIdByName(fullBook.getPublisher().getNameP()));
        fullBook.getAuthor().setId(authorService.getIdByName(fullBook.getAuthor().getFio()));
        fullBook.getGenre().setId(genreService.getIdByName(fullBook.getGenre().getNameG()));
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
//            fullBook.setNameG(name);
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
//    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public String deleteBookById(@PathVariable long id) {
        bookService.deleteBookById(id);
        return "index.html";
    }
}
