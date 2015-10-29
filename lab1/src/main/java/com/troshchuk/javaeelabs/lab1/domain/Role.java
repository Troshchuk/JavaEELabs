package com.troshchuk.javaeelabs.lab1.domain;

import com.troshchuk.javaeelabs.lab1.annotation.Id;
import com.troshchuk.javaeelabs.lab1.annotation.Column;

public class Role {
    private long id;
    private String role;

    @Id
    @Column(name = "role_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
