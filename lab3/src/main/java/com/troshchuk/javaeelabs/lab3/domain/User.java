package com.troshchuk.javaeelabs.lab3.domain;

import javax.persistence.*;

@Entity
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
    @GeneratedValue(strategy= GenerationType.AUTO)
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
