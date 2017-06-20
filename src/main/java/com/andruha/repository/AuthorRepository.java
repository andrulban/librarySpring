package com.andruha.repository;

import com.andruha.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by andrusha on 19.06.17.
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
