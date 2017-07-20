package com.andruha.repository;

import com.andruha.model.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

/**
 * Created by andrusha on 20.06.17.
 */
@Service
/**
 * Just a repository of genres.
 */
public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findGenreByNameG(String name);
    @Query("select id from Genre g where g.nameG = ?1")
    Long getIdByName(String name);
}
