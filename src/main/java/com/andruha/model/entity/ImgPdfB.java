package com.andruha.model.entity;

import javax.persistence.*;

/**
 * Created by andrusha on 20.06.17.
 */
@Entity
@Table(name = "book")
/**
 * Entity from DB. It is part of book table, it is book's content and image.
 */
public class ImgPdfB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "content")
    private byte[] content;
    @Column(name = "image")
    private byte[] image;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
