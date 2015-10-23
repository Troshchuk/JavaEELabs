package com.troshchuk.photoLibrary.domain;

import com.troshchuk.photoLibrary.annotation.Column;
import com.troshchuk.photoLibrary.annotation.Id;
import com.troshchuk.photoLibrary.annotation.Table;

@Table(name = "Users")
public class User {
    private long id;
    private String email;
    private Password password;

    public User() {
    }

    public User(String email) {
        this.email = email;
    }

    @Id
    @Column(name = "user_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
