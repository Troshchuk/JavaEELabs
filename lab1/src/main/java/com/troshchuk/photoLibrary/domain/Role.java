package com.troshchuk.photoLibrary.domain;

import com.troshchuk.photoLibrary.annotation.Column;
import com.troshchuk.photoLibrary.annotation.Id;

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
