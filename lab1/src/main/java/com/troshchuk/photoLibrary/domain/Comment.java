package com.troshchuk.photoLibrary.domain;

import com.troshchuk.photoLibrary.annotation.Column;
import com.troshchuk.photoLibrary.annotation.Id;
import com.troshchuk.photoLibrary.annotation.Table;

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

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
