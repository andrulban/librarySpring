package com.andruha.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by andrusha on 29.07.17.
 */
@Entity
@Table(name = "authentication")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private long id;
    @Column(name = "userName", nullable = false, unique = true, length = 20)
    private String userName;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email")
    private String email;

    public User() {
    }

    public User(User user) {
        this.id = user.id;
        this.userName = user.userName;
        this.password = user.password;
        this.email = user.email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
