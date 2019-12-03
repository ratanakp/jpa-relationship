package com.example.demojparelationshipbeforeclass.entities.manytomanyextracolumn.style1;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "PostTag")
public class PostTag {

    @EmbeddedId
    private PostTagId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("postId")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("tagId")
    private Tag tag;

    @Column(name = "created_on")
    private Date createdOn = new Date();

    public PostTag() {
    }

    public PostTag(PostTagId id, Post post, Tag tag, Date createdOn) {
        this.id = id;
        this.post = post;
        this.tag = tag;
        this.createdOn = createdOn;
    }

    public PostTagId getId() {
        return id;
    }

    public void setId(PostTagId id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    // Optional but recommend
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        PostTag that = (PostTag) obj;

        return Objects.equals(post, that.post) && Objects.equals(tag, that.tag);
    }

    // Optional but recommend
    @Override
    public int hashCode() {
        return Objects.hash(post, tag);
    }

    @Override
    public String toString() {
        return "PostTag{" +
                "id=" + id +
                ", post=" + post +
                ", tag=" + tag +
                ", createdOn=" + createdOn +
                '}';
    }


}
