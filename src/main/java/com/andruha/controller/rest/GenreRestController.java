package com.andruha.controller.rest;

import com.andruha.model.entity.Genre;
import com.andruha.service.implementations.GenreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by andrusha on 01.08.17.
 */
@RestController
public class GenreRestController {
    private GenreServiceImpl genreService;

    @Autowired
    public void setGenreService(GenreServiceImpl genreService) {
        this.genreService = genreService;
    }


    /**
     * It downloads list of all genres.
     * @return
     */
    @RequestMapping(value = "/genres", method = RequestMethod.GET)
    public List<Genre> getAllGenres(){
        return genreService.getAllGenre();
    }
}
