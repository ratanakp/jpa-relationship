package com.example.demojparelationshipbeforeclass.entities.manytomanyextracolumn.simpleone;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag {

    @Id
    @GeneratedValue
    public Long id;

    public String name;

    public Tag() {
    }

    // tags here comes from tags attribute of Post class
    @OneToMany(mappedBy = "tags", targetEntity = Post.class, fetch = FetchType.LAZY)
    List<Post> posts;

    public Tag(String name) {
        this.name = name;
    }

}
