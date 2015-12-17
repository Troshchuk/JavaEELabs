package com.troshchuk.javaeelabs.lab3.domain;

import javax.persistence.*;

@Entity
@Table(name = "Comments")
public class Comment {
    private long id;
    private Photo photo;
    private String comment;

    @Id
    @Column(name = "comment_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
