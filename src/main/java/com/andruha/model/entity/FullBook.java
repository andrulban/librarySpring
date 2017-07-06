package com.andruha.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by andrusha on 24.06.17.
 */
@Entity
@Table(name = "book")
public class FullBook extends BookAbstract implements Serializable {
    @Column(name = "image")
    private byte[] image;
    @Column(name = "content")
    private byte[] content;

    public FullBook() {
        super();
    }

    public FullBook(long author_id, long genre_id, long publisher_id, String name, int pageCount, String isbn, Integer publishYear, byte[] image, byte[] content) {
        super(author_id, genre_id, publisher_id, name, pageCount, isbn, publishYear);
        this.image = image;
        this.content = content;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
