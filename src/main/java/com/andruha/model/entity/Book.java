package com.andruha.model.entity;

import org.hibernate.annotations.Target;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.*;

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

    @Column(name = "author_id", nullable = false)
    private long author_id;
    @Column(name = "genre_id", nullable = false)
    private long genre_id;
    @Column(name = "publisher_id", nullable = false)
    private long publisher_id;

    public Book() {

    }

    public long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(long author_id) {
        this.author_id = author_id;
    }

    public long getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(long genre_id) {
        this.genre_id = genre_id;
    }

    public long getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(long publisher_id) {
        this.publisher_id = publisher_id;
    }
}
