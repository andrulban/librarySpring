package com.andruha.model.entity;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

/**
 * Created by andrusha on 19.06.17.
 */
/**
 * Main entity from DB it has 3 FK and it does not have its image and pdf content there, img and pdf are in another entity.
 */
@Entity
@Table(name = "book")
public class Book extends BookAbstract {

    public Book() {

    }

    public Book(long author_id, long genre_id, long publisher_id, String name, int pageCount, String isbn, Integer publishYear) {
        super(author_id, genre_id, publisher_id, name, pageCount, isbn, publishYear);
    }

}
