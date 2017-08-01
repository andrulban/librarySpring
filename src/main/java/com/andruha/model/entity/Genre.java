package com.andruha.model.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by andrusha on 19.06.17.
 */
@Entity
@Table(name = "genre")
/**
 * Simple entity from DB.
 */
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id", nullable = false)
    private Long id;
    @Column (name = "name", nullable = false, length = 25)
    @Size(min = 3, max = 25, message = "Fill genre name, min 3, max 25 symbols")
    private String nameG;

    public Genre() {
    }

    public Genre(String nameG) {
        this.nameG = nameG;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameG() {
        return nameG;
    }

    public void setNameG(String nameG) {
        this.nameG = nameG;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Genre other = (Genre) obj;
        if (getId() != other.getId() && (getId() == null || !getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNameG();
    }
}
