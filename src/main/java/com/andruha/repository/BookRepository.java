package com.andruha.repository;

import com.andruha.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by andrusha on 19.06.17.
 */

@Service
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("select b from Book b where b.genre_id = ?1")
    List<Book> findAllByGenre_id(Long id);

    List<Book> findBooksByNameContains(String name);

    List<Book> findBooksByNameStartsWith(String letter);

    Book getBookById(long id);

    void deleteBookById(long id);

}
