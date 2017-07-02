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
