package com.andruha.service_test;

import com.andruha.model.entity.Genre;
import com.andruha.service.interfaces.GenreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by andrusha on 20.06.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GenreServiceTest {
    private GenreService genreService;

    @Autowired
    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }

    @Test
    public void genreServiceTest1(){
        String genre = genreService.getGenreNameById(19);
        assertNotNull(genre);
    }

    @Test
    public void genreServiceTest2(){
        String genre = genreService.getGenreNameById(19);
        String  sameGenre = genreService.getGenreNameById(19);
        assertEquals(genre,genre);
        assertEquals(sameGenre,sameGenre);
        assertEquals(genre,sameGenre);
    }

    @Test
    public void genreServiceTest3(){
        String genre22 = genreService.getGenreNameById(22);
        String  genre23 = genreService.getGenreNameById(23);
        assertNotEquals(genre22,genre23);
    }
}
