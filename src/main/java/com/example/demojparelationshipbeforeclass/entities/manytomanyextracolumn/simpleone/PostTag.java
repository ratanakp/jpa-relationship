package com.example.demojparelationshipbeforeclass.entities.manytomanyextracolumn.simpleone;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * The join table
 * We **CAN'T** use the default generated entity name "post_tag" because this entity name is already used by the @JoinTable definition in the Post entity,
 * this would throw an exception like "SQL strings added more than once for: post_tag".
 * We must override the entity name and and set whatever else, here "PostTagEntity".
 * Because the entity name is different than the table name, we must set the @Table to map explicitly this entity on this table.
 */
@Entity(name = "PostTagEntity")
@Table(name = "post_tag")

//@AssociationOverrides({
//        @AssociationOverride(name = "id.postId",
//                joinColumns = @JoinColumn(name = "POST_ID_MEME")),
//        @AssociationOverride(name = "id.tagId",
//                joinColumns = @JoinColumn(name = "TAG_ID"))})
public class PostTag {

    @EmbeddedId
    public PostTagId id;

    // Our extra column
    public Instant createdDate;

    public String name;

    public PostTag() {
    }

    public PostTag(PostTagId id, Instant createdDate, String name) {
        this.id = id;
        this.createdDate = createdDate;
        this.name = name;
    }

    // create by our own to easily save post/tag no need to set to postTagId first.
    public PostTag(Post post, Tag tag, String name) {
        this.id = new PostTagId();
        this.id.postId = post.id;
        this.id.tagId = tag.id;
        this.createdDate = Instant.now();
        this.name = name;
    }


    public PostTagId getId() {
        return id;
    }

    public void setId(PostTagId id) {
        this.id = id;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PostTag{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                ", name='" + name + '\'' +
                '}';
    }

    @Embeddable
    public static class PostTagId implements Serializable {

        @Column(name = "post_id")
        public Long postId;
        @Column(name = "tag_id")
        public Long tagId;

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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PostTagId)) return false;
            PostTagId postTagId = (PostTagId) o;
            return Objects.equals(postId, postTagId.postId) &&
                    Objects.equals(tagId, postTagId.tagId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(postId, tagId);
        }
    }
}
