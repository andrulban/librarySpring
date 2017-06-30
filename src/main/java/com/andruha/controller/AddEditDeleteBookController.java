package com.andruha.controller;

import com.andruha.model.entity.FullBook;
import com.andruha.service.interfaces.BookService;
import com.andruha.service.interfaces.FullBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.andruha.model.entity.Book;

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
     * @return
     */
    @RequestMapping(value = "/bookEdition", method = RequestMethod.GET)
    public String editBook() {
        return "pages/editBook.html";
    }

    /**
     * Method which edits selected book and redirects back to index again.
     * @param book
     * @return
     */
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public String editBook(@RequestBody Book book) {
        bookService.editBookById(book);
        return "pages/index.html";
    }

    /**
     * Method which redirects to html where book is added.
     * @return
     */
    @RequestMapping(value = "/bookAdding", method = RequestMethod.GET)
    public String addBook() {
        return "pages/addBook.html";
    }

    /**
     * Method which adds new book and redirects back to index again.
     * @param fullBook
     * @return
     */
    @RequestMapping(value = "/books", method = RequestMethod.PUT)
    public String addBook(@RequestBody FullBook fullBook) {
        fullBookService.createFullBook(fullBook);
        return "pages/index.html";
    }

//    @RequestMapping(value = "/doAddBook", method = RequestMethod.POST)
//    public String doAddBook(@RequestBody FullBook fullBook, @RequestParam(name = "image")MultipartFile image, @RequestParam (name = "content") MultipartFile content) {
//        try {
//            fullBook.setContent(content.getBytes());
//            fullBook.setImage(image.getBytes());
//        }
//        catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        fullBookService.createFullBook(fullBook);
//        return "pages/index.html";
//    }

    /**
     * Method which deletes book by id and redirects back to index again.
     * @param id
     * @return
     */
    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public String deleteBookById(@PathVariable long id){
        bookService.deleteBookById(id);
        return "pages/index.html";
    }


}
