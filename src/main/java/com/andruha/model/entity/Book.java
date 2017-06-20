package com.andruha.model.entity;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

/**
 * Created by andrusha on 19.06.17.
 */

@Entity
@Table(name = "book")
public class Book {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private long id;
    @Column(name = "author_id", nullable = false)
    private long author_id;
    @Column(name = "genre_id", nullable = false)
    private long genre_id;
    @Column(name = "publisher_id", nullable = false)
    private long publisher_id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "page_count", nullable = false)
    private int pageCount;
    @Column(name = "isbn", nullable = false)
    private String isbn;
    @Column(name = "publish_year")
    private Integer publish_year;

    public Book() {
    }

    public Book(long author_id, long genre_id, long publisher_id, String name, int pageCount, String isbn, Integer publish_year) {
        this.author_id = author_id;
        this.genre_id = genre_id;
        this.publisher_id = publisher_id;
        this.name = name;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.publish_year = publish_year;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageCount() {
        return this.pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public void setId(long id) {
        this.id = id;
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

    public Integer getPublish_year() {
        return publish_year;
    }

    public void setPublish_year(Integer publish_year) {
        this.publish_year = publish_year;
    }
}
