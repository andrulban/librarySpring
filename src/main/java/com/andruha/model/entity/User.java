package com.andruha.model.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by andrusha on 29.07.17.
 */
@Entity
@Table(name = "authentication")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private long id;
    @Column(name = "userName", nullable = false, unique = true, length = 20)
    @Size(min = 3, max = 20, message = "Username length from 3 to 20 characters")
    private String userName;
    @Column(name = "password", nullable = false)
    @Size(min = 8, max = 100, message = "Password length from 8 to 20 characters")
    private String password;
    @Column(name = "email", unique = true)
    @NotEmpty(message = "Please enter your email address")
    @Email(message = "Email is incorrect")
    @Size(max = 40, message = "Max size is 40 symbols")
    private String email;
    @Column(name = "permissionLevel")
    private int permission;

    public User() {
    }

    public User(User user) {
        this.id = user.id;
        this.userName = user.userName;
        this.password = user.password;
        this.email = user.email;
        this.permission = user.permission;
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

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }
}
