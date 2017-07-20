package com.andruha.repository;

import com.andruha.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

/**
 * Created by andrusha on 19.06.17.
 */
@Service
/**
 * Just a repository of authors.
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {
        Author findAuthorByFio(String fio);
        @Query("select id from Author a where a.fio = ?1")
        Long getIdByName(String name);
}
