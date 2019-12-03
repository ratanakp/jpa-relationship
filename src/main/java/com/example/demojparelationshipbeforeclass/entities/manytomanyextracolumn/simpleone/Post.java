package com.example.demojparelationshipbeforeclass.entities.manytomanyextracolumn.simpleone;

import javax.persistence.*;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue
    public Long id;

    public String title;

    @ManyToMany
    @JoinTable(name = "post_tag",
            joinColumns = @JoinColumn(referencedColumnName = "id", name = "post_id"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "id", name = "tag_id"))
    public List<Tag> tags;

    public Post() {
    }

    public Post(String title) {
        this.title = title;
    }

}

