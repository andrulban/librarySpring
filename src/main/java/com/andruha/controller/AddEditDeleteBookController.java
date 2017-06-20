package com.andruha.controller;

import com.andruha.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.andruha.model.entity.Book;

/**
 * Created by andrusha on 20.06.17.
 */
@Controller
public class AddEditDeleteBookController {
    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Method which redirects to html where book is edited.
     * @return
     */
    @RequestMapping("/editBook")
    public String editBook() {
        return "pages/editBook.html";
    }

    /**
     * Method which edits selected book and redirects back to index again.
     * @param book
     * @return
     */
    @RequestMapping(value = "/doEditBook", method = RequestMethod.POST)
    public String doEditBook(@RequestBody Book book) {
        bookService.editBookById(book);
        return "pages/index.html";
    }

    /**
     * Method which redirects to html where book is added.
     * @return
     */
    @RequestMapping("/addBook")
    public String addBook() {
        return "pages/addBook.html";
    }

    /**
     * Method which adds new book and redirects back to index again.
     * @param book
     * @return
     */
    @RequestMapping(value = "/doAddBook", method = RequestMethod.POST)
    public String doAddBook(@RequestBody Book book) {
        bookService.createBook(book);
        return "pages/index.html";
    }

    /**
     * Method which deletes book by id and redirects back to index again.
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteBook/{id}")
    public String deleteBookById(@PathVariable long id){
        bookService.deleteBookById(id);
        return "pages/index.html";
    }


}
