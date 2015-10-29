package com.troshchuk.javaeelabs.lab1.domain;

import com.troshchuk.javaeelabs.lab1.annotation.Column;
import com.troshchuk.javaeelabs.lab1.annotation.Table;

@Table(name = "Passwords")
public class Password {
    private long userId;

    private String password;

    public Password() {
    }

    public Password(User user, String password) {
        userId = user.getId();
        this.password = password;
    }

    @Column(name = "user_id")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
