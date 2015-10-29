package com.troshchuk.javaeelabs.lab1.domain;

import com.troshchuk.javaeelabs.lab1.annotation.Id;
import com.troshchuk.javaeelabs.lab1.annotation.Column;
import com.troshchuk.javaeelabs.lab1.annotation.Table;

@Table(name = "Photos")
public class Photo {
    private long id;

    private String name;

    private String source;

    public Photo() {
    }

    public Photo(long id, String name, String source) {
        this.id = id;
        this.name = name;
        this.source = source;
    }

    @Id
    @Column(name = "photo_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "source")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
