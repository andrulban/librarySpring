package com.andruha.repository;

import com.andruha.model.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by andrusha on 20.06.17.
 */
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
