package com.troshchuk.photoLibrary.domain;

import com.troshchuk.photoLibrary.annotation.Column;
import com.troshchuk.photoLibrary.annotation.Table;

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
