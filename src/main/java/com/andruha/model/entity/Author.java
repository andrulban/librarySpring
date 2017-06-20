package com.andruha.model.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by andrusha on 19.06.17.
 */
@Entity
@Table(name="author")
/**
 * Simple entity from DB.
 */
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "fio", nullable = false)
    private String allNames;
    @Column(name = "birthday", nullable = false)
    private Date birthdayDate;

    public Author() {
    }

    public Author(Date birthdayDate, Long id, String allNames) {
        this.birthdayDate = birthdayDate;
        this.id = id;
        this.allNames = allNames;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAllNames() {
        return allNames;
    }

    public void setAllNames(String allNames) {
        this.allNames = allNames;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + (getId() != null ? getId().hashCode() : 0);
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
        final Author other = (Author) obj;
        if (getId() != other.getId() && (getId() == null || !getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getAllNames();
    }


}
