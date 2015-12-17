package com.troshchuk.javaeelabs.lab3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
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
