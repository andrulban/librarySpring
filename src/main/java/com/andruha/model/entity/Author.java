package com.andruha.model.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by andrusha on 19.06.17.
 */
@Entity
@Table(name="author")
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
}
