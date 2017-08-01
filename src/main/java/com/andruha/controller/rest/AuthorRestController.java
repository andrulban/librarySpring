package com.andruha.controller.rest;

import com.andruha.service.interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by andrusha on 01.08.17.
 */
@RestController
public class AuthorRestController {
    private AuthorService authorService;

    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    /**
     * It downloads author name by its id.
     * @param id
     * @return
     */
    @RequestMapping(value = "/authorName/{id}", method = RequestMethod.GET)
    public String getAuthorName(@PathVariable long id){
        return authorService.getNameById(id);
    }

}
