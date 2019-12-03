package com.example.demojparelationshipbeforeclass.entities.manytomanyextracolumn.style1;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PostTagId implements Serializable {

    @Column(name = "post_id")
    private Long postId;

    @Column(name = "tag_id")
    private Long tagId;

    public PostTagId() {
    }


    public PostTagId(Long postId, Long tagId) {
        this.postId = postId;
        this.tagId = tagId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "PostTagId{" +
                "postId=" + postId +
                ", tagId=" + tagId +
                '}';
    }


    // Optional but recommend
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        PostTagId that = (PostTagId) obj;

        return Objects.equals(postId, that.postId) && Objects.equals(tagId, that.tagId);
    }

    // Optional but recommend
    @Override
    public int hashCode() {
        return Objects.hash(postId, tagId);
    }
}
