package com.andruha.controller;

import com.andruha.model.entity.User;
import com.andruha.service.interfaces.ImgPdfBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author andrusha
 */
@Controller
public class BooksController {

    @RequestMapping("/books")
    public String books(@RequestParam(name = "name", defaultValue = "andruha") String name, @RequestParam(name = "password", defaultValue = "bog") String password) {
        return "pages/books.html";
    }
}
