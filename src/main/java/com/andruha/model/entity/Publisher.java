package com.andruha.model.entity;

import javax.persistence.*;

/**
 * Created by andrusha on 19.06.17.
 */
@Entity
@Table(name = "publisher")
/**
 * Simple entity from DB.
 */
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", length = 100)
    private String nameP;

    public Publisher() {
    }

    public Publisher(String nameP) {
        this.nameP = nameP;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (getId() != null ? getId().hashCode() : 0);
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
        final Publisher other = (Publisher) obj;
        if (getId() != other.getId() && (getId() == null || !getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNameP();
    }
}
