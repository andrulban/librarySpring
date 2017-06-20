package com.andruha.service.implementations;

import com.andruha.model.entity.Genre;
import com.andruha.repository.GenreRepository;
import com.andruha.service.interfaces.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by andrusha on 20.06.17.
 */
@Service
public class GenreServiceImpl implements GenreService {

    private GenreRepository genreRepository;

    @Autowired
    public void setGenreRepository(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> getAllGenre() {
        return genreRepository.findAll();
    }

    @Override
    public String getGenreNameById(long id) {
        return genreRepository.findOne(id).getGenreName();
    }
}
