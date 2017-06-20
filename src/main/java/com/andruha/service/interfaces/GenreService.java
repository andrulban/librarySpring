package com.andruha.service.interfaces;

import com.andruha.model.entity.Genre;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by andrusha on 20.06.17.
 */
@Service
public interface GenreService {
    List<Genre> getAllGenre();
    String  getGenreNameById(long id);
}
